

Task 1: The Object blueprint classes
Create the following well-structured classes:

Pet class with the following attributes:
- Unique Pet ID
- Name
- Species/Breed
- Age
- Owner name
- Contact Info
- Registration date
- List of appointments, using an appropriate collection object.

Appointment class with the following attributes:
- Appointment type (such as vet visit, vaccination, grooming)
- Date and time
- Notes (optional)

Important: Use encapsulation to protect data and keep your code organized.

Task 2: The main application

Create the PetCare Scheduler application that will:

Load Data: Load any existing data from the files, when the application starts up. Ensure this method is private.
Take and Process user input: Take user input and process it to perform one of the allowed operations:
Register a pet
Schedule an appointment
Store the details in a file
Display details of pets and/or appointments
Generate reports


Task 3: Add the methods to handle user input
Register the pet: Create new pet profiles that contain the following information:
- Anique Pet ID. Handle ID duplication.
- Name
- Species/Breed
- Age. Handle any errors that can be caused by invalid inputs.
- Owner/Contact name
- Registration date. Use the Date & Time packages to record pet registration dates. Handle any errors that can be caused by invalid inputs.
- Add the pet to the collection

Schedule an ppointment: Allow users to schedule appointments for a pet, including:
- Appointment type (such as vet visit, vaccination, grooming)
- Date and time of appointment. Handle any errors that can be caused by invalid inputs.
- Notes if needed
- Add the appointment to the collection for that pet.

Display the records: Show the following information based on the option chosen:
- All registered pets
- All appointments for a specific pet
- Upcoming appointments for all pets
- Past appointment history for each pet

Store data: Save pet profiles and appointment records to files using Java File I/O so data persists when the program closes. Handle any errors that can be caused during File I/O.

Generate reports: Produce simple reports including:
- Pets with upcoming appointments in the next week
- Pets overdue for a vet visit (For example: No vet visit in the last 6 months)

Task 4: Compile and run
Compile all the file you have created and run the application and verify that the application functions as per the requirements.

How this project is graded
After completing this graded project, you will complete the graded evaluation. Most of the questions for this evaluation will require that you copy and paste your code into the graded assignment submission fields. Consider saving your code to a locally stored file to make this process easier.

You can earn a total of 50 points for this project based on the following point distribution system for each of the following questions:

Provide the code that creates the Pet Class. (5 points)
Provide the code for the appointment class. (4 points)
Select the best option for handling the appointment date and time in the Appointment Class. (1 point)
Specify which class you use to specify the requested date and time format. (2 points)
Specify the which class processes user input. (3 points)
Provide the code that handles user choices. (3 points)
Provide the code that handles pet registration. (3 points)
Provide the code that handles appointment scheduling. (4 points)
Provide the code that displays data based on the project requirements. (7 points)
Provide the code that saves pet and appointment scheduling data. (3 points)
Provide the code that addresses loading data from a file. (4 points)
Provide the code that generates reports based on the project requirements. (3 points)
Provide the User menu output that you see when you run the application. (3 points)
Provide the output obtained when you register a pet. (3 points)
Provide the output obtained when you schedule an appointment. (2 points)
Next steps
Here are some tips for successfully completing the PetCare Scheduler project:
