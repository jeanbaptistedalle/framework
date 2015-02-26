package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import dto.CustomerDTO;

/**
 * Cette classe est une entité référençant la table Customer (cf
 * database/customer.sql) se trouvant en base de données. Grâce au mapping
 * d'Hibernate, les différents attributs sont reconnus comme correspondant aux
 * colonnes associées.
 * 
 * Une instance non enregistrée en base de donnée sera donc une instance de cet
 * objet qui n'a pas d'équivalence en base de données.
 * 
 * De plus, on fournit en début de classe des requêtes nommées, qui pourront
 * être appelée dans le DAO grâce à la méthode createNamedQuery(nomRequete).
 * L'avantage de définir les requêtes de cette façon est qu'elles sont
 * précompilées lors du lancement du serveur, alors qu'une requête "en dur" dans
 * le code ne sera compilée que lors de son execution. Ainsi, si une
 * modification de la structure rend incorrect une requête, on le saura
 * immédiatement !
 *
 */
@Entity
@Table(name = "Customer")
@NamedQueries({
		@NamedQuery(name = "Customer.findByName", query = "from Customer c where c.name = :name"),
		@NamedQuery(name = "Customer.findByAdress", query = "from Customer c where c.address = :address"),
		@NamedQuery(name = "Customer.findByNameAndAddress", query = "from Customer c where c.address = :address and c.name = :name") })
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1710234886606599946L;

	/*
	 * customerId est ici noté comme étant une clef primaire grâce à @Id, qui
	 * correspond à la colonne customerId grâce à @Column et finalement, qu'elle
	 * est générée grâce à @GeneratedValue.
	 * 
	 * L'annotation @Column est facultative si le nom de l'attribut correspond
	 * au nom de la colonne. Dans notre cas, toutes les annotations @Column
	 * auront donc pu être supprimées.
	 */
	@Id
	@Column(name = "customerId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "createdDate")
	private Date createdDate;

	public Customer() {

	}

	public Customer(final String name, final String address, final Date createdDate) {
		this.name = name;
		this.address = address;
		this.createdDate = createdDate;
	}

	public Customer(final Long customerId, final String name, final String address,
			final Date createdDate) {
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.createdDate = createdDate;
	}

	public Long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(final Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(final Date createdDate) {
		this.createdDate = createdDate;
	}

	public CustomerDTO entity2Bean() {
		return new CustomerDTO(this.customerId, this.name, this.address, this.createdDate);
	}
}
