<h1><b>Book Land - Server Side</b></h1>
<p>An Online Book Store</p>

<h3>Created with Spring Rest, Spring Security, JPA, Hibernate and MySQL</h3>

<h2>How to run project locally</h2>
<ul>
  <ol>1. Make sure Java 8, MySQL Server is installed in your system</ol>
  <ol>2. Edit Application.properties file and fill in the configuration details</ol>
  <ol>3. Run the Application, which will create neceassary DB Structure in your configured MySQL server</ol>
  <ol>4. Import the CSV files added in DB_data folder into the repective tables</ol>
  <ol>5. There are 2 roles assigned to the API's and all POST / DELETE requests will work with Admin credentials in Basic Auth ( admin:adminSecret ) and GET API's will assume USER role and their credentials goes as ( user:userSecret )</ol>
</ul>

<h3>Postman Collection attached in the root as postman.json, please import it and play around</h3>
