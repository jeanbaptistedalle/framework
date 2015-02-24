package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import service.CustomerService;
import bean.CustomerDTO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author JBD
 *
 *         Cette classe fournit les différentes actions disponibles pour la page
 *         customer.jsp
 * 
 *         Ainsi, cette classe correspond au controlleur de la couche
 *         présentation.
 *         
 *         Afin d'utiliser des actions Struts2 avec Spring, un bean correspondant à cette classe se trouve dans CustomerBean.xml
 * 
 *         !!ATTENTION!! Les méthodes des classes Action ne peuvent appeler que
 *         des méthodes de la couche Service ! Il est formellement interdit
 *         d'appeler une méthode d'un DAO dans la couche présentation !!
 *
 */
public class ListCustomerAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6874495899552728610L;


	private static final String SUCCESS = "success";


	private List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();
	private CustomerDTO customer;

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
	 * Cette methode est une action (définie dans le fichier struts.xml) qui
	 * permet d'initialiser la liste des clients
	 * 
	 * @return
	 */
	public String listCustomer() {

		/*
		 * Comme précédèmment, on récupère les données grâce à des appels à la
		 * couche service
		 */
		customerList = customerService.listCustomer();

		return SUCCESS;
	}

	/**
	 * Cette methode permet de supprimer le client fournit en paramètre par la
	 * requête
	 * 
	 * @return
	 */
	public String deleteCustomer() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(
				ServletActionContext.HTTP_REQUEST);
		try {
			/*
			 * On récupère dans la requete le paramètre nécessaire au traitement
			 */
			final Long customerId = Long.parseLong(request.getParameter("customerId"));
			if (customerId != null) {
				customerService.deleteCustomer(customerId);
			}
		} catch (final Exception e) {
			// do nothing
		}
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