package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.CustomerDTO;

/**
 * @author JBD
 *
 *         Cette classe fournit les différentes actions disponibles pour la page
 *         customer.jsp
 * 
 *         Ainsi, cette classe correspond au controlleur de la couche
 *         présentation.
 * 
 *         !!ATTENTION!! Les méthodes des classes Action ne peuvent appeler que
 *         des méthodes de la couche Service ! Il est formellement interdit
 *         d'appeler une méthode d'un DAO dans la couche présentation !!
 *
 */
@Component
public class CustomerAction {

	private static final String SUCCESS = "success";

	private CustomerDTO customer = new CustomerDTO();
	private List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();

	/*
	 * Cette annotation permet à Spring d'injecter la dépendance à cette classe.
	 * Si la configuration est bonne (le bean doit être défini dans le fichier
	 * CustomerBean.xml), Spring se chargera d'initialiser CustomerService, puis
	 * d'utiliser setCustomerService() afin d'injecter la dépendance dans cette
	 * classe.
	 */
	@Autowired
	private CustomerService customerService;

	/**
	 * Cette méthode est une action (définie dans struts.xml) qui permet de
	 * sauvegarder le client courrant. Cette action étant appelé lors de la
	 * validation du formulaire de la page customer.jsp, l'instance de customer
	 * contiendra les données du formulaire
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addCustomer() throws Exception {

		customer.setCreatedDate(new Date());
		/*
		 * On envoie le customer à la couche service afin qu'il soit enregistré
		 */
		customerService.addCustomer(customer);

		/*
		 * Puis on recré la liste des clients. Celle-ci provient elle aussi de
		 * la couche service
		 */
		customerList = customerService.listCustomer();

		/*
		 * On suppose ici que le traitement est réussi, on renvoie donc
		 * "success". Si on voulait faire intervenir une gestion d'erreur plus
		 * poussée, il suffirait de créer de nouveau message puis de définir le
		 * comportement attendu dans le struts.xml
		 */
		return SUCCESS;
	}

	/**
	 * Cette methode permet d'initialiser la liste des clients
	 * 
	 * @return
	 * @throws Exception
	 */
	public String listCustomer() throws Exception {

		/*
		 * Comme précédèmment, on récupère les données grâce à des appels à la
		 * couche service
		 */
		customerList = customerService.listCustomer();

		return SUCCESS;

	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public List<CustomerDTO> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerDTO> customerList) {
		this.customerList = customerList;
	}
}