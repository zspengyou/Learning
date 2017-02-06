package java8.filteredList;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FilteredTableViewExample extends Application {
	private TableView<Employee> table;
	private TextField txtField;
	private FilteredList<Employee> tableData;
	private ObservableList<Employee> data;

	//    MyService myService;

	@Override
	public void start(Stage stage) throws Exception {
		Label lbl = new Label("Enter text below to filter: ");
		initFilter();
		initTable();

		//        myService = new MyService();
		//
		//        myService.setDelay(new Duration(300));
		//        myService.setPeriod(new Duration(1000));
		//
		//        myService.start();

		VBox container = new VBox();
		container.getChildren().addAll(lbl, txtField, table);
		StackPane root = new StackPane();
		root.getChildren().add(container);
		Scene scene = new Scene(root, 500, 400);
		stage.setScene(scene);
		stage.show();
	}
	//
	//    class MyService extends ScheduledService<List<Employee>> {
	//        @Override
	//        protected Task<List<Employee>> createTask() {
	//            Task<List<Employee>> task = new Task<List<Employee>>() {
	//                @Override
	//                protected List<Employee> call() throws Exception {
	//                    return getTableData();
	//                }
	//            };
	//            task.setOnSucceeded(e -> data.setAll(task.getValue()));
	//            return task ;
	//        }
	//    }

	public static void main(String[] args) {
		launch(args);
	}

	private void initTable() {
		table = new TableView<>();
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		TableColumn<Employee, String> empIdCol = new TableColumn<>("Employee ID");
		empIdCol.setCellValueFactory(p -> p.getValue().empIdProperty());

		TableColumn<Employee, String> nameCol = new TableColumn<>("Name");
		nameCol.setCellValueFactory(p -> p.getValue().nameProperty());

		TableColumn<Employee, Number> ageCol = new TableColumn<>("Age");
		ageCol.setCellValueFactory(p -> p.getValue().ageProperty());

		TableColumn<Employee, String> cityCol = new TableColumn<>("City");
		cityCol.setCellValueFactory(p -> p.getValue().cityProperty());

		table.getColumns().setAll(empIdCol, nameCol, ageCol, cityCol);

		data = FXCollections.observableArrayList(getTableData());
		tableData = new FilteredList<>(data);
		table.setItems(tableData);
	}

	private void initFilter() {
		txtField = new TextField();
		txtField.setPromptText("Filter");
		txtField.textProperty().addListener((obs, oldText, newText) -> {
			if (txtField.textProperty().get().isEmpty()) {
				tableData.setPredicate(employee -> true);
				return;
			}

			tableData.setPredicate(employee -> {
				String text = newText.toLowerCase();
				for (TableColumn<Employee, ?> col : table.getColumns()) {
					String cellValue = col.getCellData(employee).toString();
					cellValue = cellValue.toLowerCase();
					if (cellValue.contains(text)) {
						return true;
					}
				}
				return false;
			});

		});
	}

	private List<Employee> getTableData() {
		List<Employee> list = new ArrayList<>();
		String[] name = { "Sriram", "Pete", "Eric", "Dawson", "John" };
		String[] city = { "New York", "Chicago", "Little Rock", "Los Angeles", "Oakland" };
		for (int i = 0; i < 5; i++) {
			Employee emp = new Employee();
			emp.setName(name[i]);
			emp.setAge((int) (Math.random() * 100));
			emp.setCity(city[i]);
			emp.setEmpId(String.valueOf(i + 1000));
			list.add(emp);
		}
		return list;
	}

}

class Employee {

	private SimpleStringProperty name = new SimpleStringProperty();
	private SimpleIntegerProperty age = new SimpleIntegerProperty();
	private SimpleStringProperty city = new SimpleStringProperty();
	private SimpleStringProperty empId = new SimpleStringProperty();

	public SimpleStringProperty nameProperty() {
		return name;
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getName() {
		return name.get();
	}

	public SimpleIntegerProperty ageProperty() {
		return age;
	}

	public void setAge(Integer age) {
		this.age.set(age);
	}

	public Integer getAge() {
		return age.get();
	}

	public SimpleStringProperty cityProperty() {
		return city;
	}

	public String getCity() {
		return city.get();
	}

	public void setCity(String city) {
		this.city.set(city);
	}

	public SimpleStringProperty empIdProperty() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId.set(empId);
	}

	public String getEmpId() {
		return empId.get();
	}
}
