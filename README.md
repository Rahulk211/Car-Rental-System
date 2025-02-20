# Car-Rental-System
A console-based Car Rental System built with Java and MySQL. This project allows customers to rent and return cars while managing available vehicles in a MySQL database.

📜 Project Description
The Car Rental System is a Java-based console application that enables:
✅ Adding and listing cars in the rental inventory.
✅ Renting cars to customers and tracking rental history.
✅ Returning cars and updating availability.
✅ Managing customer details.

The system uses MySQL as the database, with Java JDBC for connectivity.

📂 Project Structure
pgsql
Copy
📦 CarRentalSystem
 ┣ 📂 src/main/java/com/carrentalsys
 ┃ ┣ 📜 CarRentalSys.java        # Manages cars (add, delete, update, list)
 ┃ ┣ 📜 Customers.java           # Handles customer details
 ┃ ┣ 📜 DatabaseConnectors.java  # Manages MySQL connection
 ┃ ┣ 📜 Rental.java              # Handles renting and returning cars
 ┃ ┣ 📜 Main.java                # Entry point for the application
 ┃ ┣ 📜 TestDBConnection.java    # Verifies database connection
 ┣ 📂 resources
 ┃ ┣ 📜 CarRentalSystem.sql      # SQL script to set up the database
 ┣ 📜 README.md                  # Documentation
 ┣ 📜 pom.xml                     # Maven dependencies
💻 Installation & Setup
1️⃣ Prerequisites
Java 21 installed (Download Java)
MySQL 8+ installed (Download MySQL)
Maven installed (Download Maven)
2️⃣ Clone the Repository
copy
git clone https://github.com/your-username/CarRentalSystem.git
cd CarRentalSystem
3️⃣ Setup MySQL Database
Option 1: Manually Import SQL File

Open MySQL Workbench or Command Line
Run:
sh
Copy
mysql -u root -p < resources/CarRentalSystem.sql

4️⃣ The project is build on maven

📌 Usage
1️⃣ Add a Car

Enter model: SUV
Enter brand: BMW
Enter price per day: 1000
🚗 Car added successfully!

2️⃣ List Available Cars

🚗 Available Cars:
ID: 1 | Model: SUV | Brand: BMW | Status: Available | Price per day: $1000

3️⃣ Rent a Car

Enter customer ID: 1
Enter car ID: 1
Enter rental duration (days): 5
✅ Car rented for 5 days. Total cost: $5000

4️⃣ Return a Car

Enter car ID: 1
✅ Car returned successfully.

🛠 Technologies Used
Java (JDBC for database connection)
MySQL (For storing cars, customers, and rental data)
Maven (For dependency management)

⚠️ Troubleshooting
1️⃣ "No Suitable Driver Found" Error
✅ Fix: Add the MySQL JDBC driver:

🤝 Contributing
Fork the repository
Create a new branch (feature-xyz)
Commit changes
Push and create a Pull Request
