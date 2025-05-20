# CV Application

An Android application showcasing a navigation drawer setup with multiple destinations including Home, Contact, Academic, and Home Conference sections.

## Overview

This project demonstrates the implementation of a navigation drawer integrated with Android Jetpack's Navigation Component. The app features:

- A `DrawerLayout` for navigation drawer functionality.
- A `Toolbar` as the app bar.
- Navigation between multiple fragments using `NavController`.
- Menu integration in the toolbar.

## Features

- Navigation drawer with menu items:
  - Home
  - Contact
  - Academic
  - Home Conference
- Action bar integration with the navigation controller.
- Smooth navigation and UI synchronization between drawer and fragments.

## MainActivity Details

The `MainActivity` is the host activity and handles:

- Setting up the `Toolbar` as the app bar.
- Initializing the `DrawerLayout` and `NavigationView`.
- Configuring the navigation graph with `NavController`.
- Linking the navigation drawer menu with navigation actions.
- Inflating the options menu.

## Usage

1. Clone the repository:
   ```bash
   git clone https://github.com/lwemzy/cvApplication.git
