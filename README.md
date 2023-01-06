# Student Support System
###### by: heytonyy

<br>

## Description:

This is a full stack Java Flask app that gives a school a communication system where teachers can add support notes for a student. This was an inspiration project from one struggle I had being a teacher: not having the time to personally reachout to each student of a teacher. This system makes it simple for teacher to add notes for their students, as well as read note from other teacerhs.

## Features:
- Designed different user account roles using the Java Spring Security for authentication and authorization to only allow counselors (admin) add students to the system, and teachers (users) only be able to add support notes.
- Implemented a custom phone number validator using the Twilio API to validate the imputed phone number is a real phone number.
- Established multiple many-to-0ne and many-to-many relationships between user and student models in order to conditionally render support note form if the student has that teacher for a given period in the students schedule.
- Utilized the Faker API and a custom controller route to quickly populate random student/guardian data for testing.

<br>

## Video Demo:
(click on the image to watch the video on youtube)

[![Watch the video](https://img.youtube.com/vi/GYm628jiW0c/maxresdefault.jpg)](https://youtu.be/GYm628jiW0c)

## TODO:
1. Host on AWS
2. Other Ideas:
    - Image upload for student form
    - Finish Look up feature on admin page
    - Drop spring, turn server to REST and make React front end?

<br>
