# What is Split Time?
Split Time is an informational website where users can learn about exercises and create a workout schedule. Users can also edit and delete their workout splits. If a user is new to exercising and doesn't know any kind of exercise, they can check the exercise page where there is a list of exercises. Each exercise contains a link to a tutorial YouTube video.

# Tech stack
* Front-End:
    * Javascript
    * HTML
    * CSS
* Back-End:
    * Java
    * Spring Boot
* Database
  * PostgreSQL

# Features
* Create a split (Day, Exercise Name, Sets, Repetitions, Type).
* Get a split/workout schedule
* Edit a split.
* Remove a split.
* Get a list of Exercises.

# How to Install and Run Split Time
1. Click the Green Code button and select "Download ZIP".
2. Open the zip file and run it in IntelliJ.
3. Go and open the FitnessAppApplication (src/main/java/com/brightpaths/fitnessApp/FitnessAppApplication.java)
4. Run the FitnessAppApplication 
5. Open Google Chrome browser and go to the "localhost:8080/login.html". 
6. Go to the Register page if you don't have an account.
7. Login using the username and password you've created.
7. Browse around and test out the features.

# IMPORTANT NOTE: 
  * The HOME PAGE does not have a video playing in the background.
  * Create a new directory in the static directory named "video" (src/main/resources/static)
  * Add your own video to this directory (src/main/resources/static/video)
  * Make sure your video is mp4 type and is named (SplitVideoProject.mp4)
  * Test and see if the video background works