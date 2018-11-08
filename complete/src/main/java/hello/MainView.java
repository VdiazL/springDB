package hello;

import java.util.Collection;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.util.StringUtils;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

/*@RepositoryRestResource(collectionResourceRel = "view", path = "view")*/

/*	public MainView() {
		add(new Button("Click me", e -> Notification.show("Hello Spring+Vaadin user!")));*/

@Route("view")
public class MainView extends VerticalLayout {

	private final PersonRepository repo;
	final Grid<Person> grid;

	
	
	public MainView(PersonRepository repo) {
		this.repo = repo;
		this.grid = new Grid<>(Person.class);
		add(grid);
		listCustomers();
	}

	private void listCustomers() {
		grid.setItems((Collection<Person>) repo.findAll());

	}

	void listCustomers(String filterText) {
		if (StringUtils.isEmpty(filterText)) {
			grid.setItems((Collection<Person>) repo.findAll());
		} else {
			grid.setItems(repo.findByLastName(filterText));
		}
		TextField filter = new TextField();
		filter.setPlaceholder("Filter by last name");
		filter.setValueChangeMode(ValueChangeMode.EAGER);
		filter.addValueChangeListener(e -> listCustomers(e.getValue()));
		add(filter, grid);
	}
	

}
