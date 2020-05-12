# GithubClient

This app displays a list of github repos based on an username.  

The app basically has a main activity that holds a fragment responsible of calling the API endpoint, build the list and show the content.  

We also have a base activity and a base fragment that implement common functionality for easy reuse among all the activities and fragments.

The app follows the clean architecture and implements the MVVM pattern.

The model consists of a Repository, Commit and Owner classes.
