# IA-Highway Mobile

IA-Highway is an application that provides a means of creating image datasets that can be used in intelligent computer vision algorithms to solve various problems such as image classification, detection, or segmentation. IA-Highway is part of an ambitious project that aims to optimize/automate the maintenance of road/rail/building infrastructures.
IA-Highway should allow a user to select/draw a region/polygon surrounding an object of interest, in this case, images of certain civil engineering structures that contain damages will be provided. After the selection process is done, the application should save the coordinates of the pixels that form the polygon in a convenient format (json, xml, database) as well as all the metadata that could be obtained from the image, such as width, height, GPS coordinates where the image was taken.
In addition to the metadata, IA-Highway must allow the user to add one or more tags related to the image and a description text. All this data must be stored as mentioned above.

## Features

* Responsive Design
* Model-View-Controller (MVC) architecture
* Canvas drawing for image labeling
* Firebase Realtime Database for dataset storage and retrieval
* Firebase Crashlytics for crash reporting and analysis

## Screenshots

![image](https://user-images.githubusercontent.com/71185753/232262094-c7e0914b-c053-4356-8969-fe5cf5476c6d.jpg)

## Getting Started

To build and run the app, follow these steps:

1. Clone the repository
2. Open the project in Android Studio
3. Connect the app to your Firebase project by following the instructions [here](https://firebase.google.com/docs/android/setup)
4. Build and run the app

## Dependencies

* Firebase Realtime Database
* Firebase Crashlytics

## Contributing 
Contributions are always welcome! If you would like to contribute to this project, please fork this repository and submit a pull request.

## Live Demo
Apk de l’application mobile : https://drive.google.com/file/d/1ug9_36V0V7PYvOf4gDp8e1oMzL_-aZXp/view?usp=sharing
