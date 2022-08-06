# HRQuiz
My first JavaFX app

There are some hints I've learned to run JavaFX app outside of IDE:
  1. Create JAR artifact (not JavaFX application):
  
  ![image](https://user-images.githubusercontent.com/65464075/183262326-b43f17d9-0434-41ea-914e-5afee9ba8aa0.png)
  
  2. In Libraries add JavaFX library (%JAVAFX_PATH%/lib):
  
  ![image](https://user-images.githubusercontent.com/65464075/183262402-dce4fe37-7680-4e56-8c47-51740bec457c.png)
  ![image](https://user-images.githubusercontent.com/65464075/183262517-e7ecf479-195e-43eb-91a6-7e0968eb5f08.png)

  3. Run app from command line as a console application with JavaFX modules: start java --module-path "PATH_TO_JAVAFX\lib" --add-modules ALL-MODULE-PATH -jar YOUR_APP.jar
  
  4. Some additional tips: it is possible to create text file with command above and make it as *.bat. Also use start javaw ... for closing console after app start up. 
