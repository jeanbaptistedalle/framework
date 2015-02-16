package service;

import java.util.List;

import bean.CustomerDTO;

/**
 * @author JBD
 *
 *         Ce service fournit des méthodes permettant d'effectuer des
 *         traitements sur les données qui lui sont envoyées. Les services font
 *         parties de la couche Service.
 *         
 *         Afin de faciliter l'injection de dépendance grâce à Spring,
 *         on préferera définir une interface de type dont le nom est
 *         <nom_de_l'entité>Service et dont l'implémentation sera
 *         <nom_de_l'entité>ServiceImpl.
 * 
 *         Les services ont un statut particulier car ils manipulent deux types
 *         d'objets gérant les données
 *
 */
public interface CustomerService {

	/**
	 * Cette méthode permet d'enregistrer un client en base de données. Le
	 * client donné en paramètre est converti en objet entité qui sera ensuite
	 * envoyé au DAO correspondant pour qu'il soit persisté en base.
	 * 
	 * @param customerDTO
	 */
	public void addCustomer(final CustomerDTO customerDTO);

	public List<CustomerDTO> listCustomer();

	public List<CustomerDTO> listCustomerByName(final String name);

}