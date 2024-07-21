# File Compression Utility

This project implements a file compression and decompression utility using Huffman coding in Java. The application reads text from an input file, compresses it into a binary format using Huffman coding, and then decompresses it to verify the correctness of the compression.

## Project Overview

The file compression utility uses Huffman coding to efficiently compress text files into a binary format. The decompression functionality ensures that the compressed data can be restored to its original form. This project is implemented using plain Java and does not use any build automation tools like Gradle or Maven.

## Features

- **Efficient Compression**: Compresses text into a binary format using Huffman coding.
- **Decompression**: Restores the original text from the compressed binary data.
- **File Handling**: Reads input from a file and writes output to files.

## Technologies Used

- Java (JDK 17 or higher)

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine.

### Prerequisites

- **Java Development Kit (JDK) 17 or higher**: Ensure you have JDK 17 installed on your system.

### Installation

1. **Clone the Repository:**

    ```sh
    git clone https://github.com/ratneeshh/FileCompressionUtility.git
    cd FileCompressionUtility
    ```

2. **Compile the Java Files:**

    - Open a terminal or command prompt and navigate to the project directory.
    - Compile the Java files:
      ```sh
      javac src/compression/*.java -d out
      ```

## Usage

1. **Prepare Input File:**

    - Place the text you want to compress in `input.txt` in the root directory.

2. **Run the Application:**

    - Execute the `Main` class using the `java` command:
      ```sh
      java -cp out compression.Main
      ```

3. **Check Outputs:**

    - The compressed binary string will be saved in `compressed.txt`.
    - The decompressed text will be saved in `decompressed.txt`.



