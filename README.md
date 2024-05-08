# Application to support learning English using Java

## Authors  
Group Troll  
  1. Mai Phan Anh Tùng - 23020433  
  2. Phạm Minh Tú - 23020429  
  3. Chu Thanh Tùng - 23020431  

## Description  
This application is built to assist in translating and learning English. It is written in the Java language and utilizes the JavaFX library. The application features translation functions for both Vietnamese-English and English-Vietnamese. It uses a dictionary.txt file to store data.  

## UML diagram
INHERITANCE TREE
![441226428_414410074853187_1773515022972598664_n](https://github.com/minhtuuse/BTL/assets/144828591/069e87d6-ad72-4f47-ab36-1a0124d3e86c)
## Installation  
 1. Clone the project from the repository.  
 2. Open the project in the IDE.
 3. Run the project.
 4. If you want to change the data, you can change the dictionary.txt.  

## Usage  
 - Select the magnifying glass button to choose the translation mode.  
     - Enter the word you want to translate into the blank space and press "Dịch" to translate.  
     - When you type a word into the blank space, there will be suggested words appearing below. Click on one of them to translate the suggested word. If the word doesn't exist, the suggestion box will display "NOT FOUND".  
     - Select the star button to save the currently translated word, and select the speaker button to pronounce the word being translated. Please note that the pronunciation function can only be used when there is an internet connection.  
     - The meaning of the word will be displayed in the blue box below, and the translation history will be shown in the top right corner. You can select a word from the translation history to translate it.    
     - In this mode, you can switch from online translation to offline translation. In online translation mode, you can choose to translate from Vietnamese to English or vice versa.  
 - Select the star button to view the list of saved words.  
     - Choose a word from the list and select "UNMARK" to remove the marking.  
 - Select a pencile button to access the dictionary editing mode:  
     - There are four functions: adding a word, editing a word, adding a meaning, and deleting a word.  
 - Select the game controller icon to play Game 1: Rewrite the scrambled words. Choose the icon with A B C D to play Game 2: Select the English word corresponding to the given meaning. The maximum score is 100 points, and the minimum score is -100 points.

## Demo  
- MAIN SCREEN  
![Screenshot 2024-05-08 192414](https://github.com/minhtuuse/BTL/assets/144828591/9e1f5f10-9bea-4ae6-bf90-bbf35a64c0f4)
- TRANSLATE SCREEN
![Screenshot 2024-05-08 192428](https://github.com/minhtuuse/BTL/assets/144828591/652bd088-4970-4005-b559-3652253f16eb)
- MARKED WORDS SCREEN
![Screenshot 2024-05-08 193151](https://github.com/minhtuuse/BTL/assets/144828591/44b006b5-adcd-47e8-ad2a-0f0d23e6ded5)
- EDIT DICTIONARY SCREEN
![Screenshot 2024-05-08 192443](https://github.com/minhtuuse/BTL/assets/144828591/1c90f6e3-fc2d-4e69-829d-4e73d80c5e54)
- REARRANGE WORD GAME SCREEN
![Screenshot 2024-05-08 192455](https://github.com/minhtuuse/BTL/assets/144828591/7a3a3eb4-2ea3-49b9-abd4-2bd91678dc29)
- FOUR CHOICES GAME SCREEN
![Screenshot 2024-05-08 192521](https://github.com/minhtuuse/BTL/assets/144828591/765d8ec9-6b67-486d-8ed0-b2d5f27f1ef0)

## Future improvements  
  1. Add more dictionaries.  
  2. Add more complex games.  
  3. Optimize the word lookup algorithm.  
  4. Use a database to store data.  
  5. Integrate the application with API of Google Translate to translate paragraphs and whole documents.  
  6. Integrate the application with API of Google Speech to Text to convert speech to text.  
  7. Improve the user interface.

## Contributing  
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.  

## Project status  
The project is completed.  

## Notes  
The application is written for educational purposes.  
