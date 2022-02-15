package guru.springframework.spring5webapp.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String addressLine1;
	private String city;
	private String state;
	private Integer zip;


	// JoinColumn : 외래키를 매핑할 때 사용
	// 출판사는 책들에 대해서 id 외래키를 가지므로 publisher_id를 작성해준다.
	@OneToMany
	@JoinColumn(name = "publisher_id")
	private Set<Book> books = new HashSet<>();

	public Publisher() {
	}


	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Publisher country = (Publisher) o;

		return id != null ? id.equals(country.id) : country.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Country{" +
						"id=" + id +
						", city='" + city + '\'' +
						", zip=" + zip +
						'}';
	}
}
