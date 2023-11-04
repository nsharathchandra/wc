```markdown
#WC (Word Count) Command

**WC** is a command-line utility that mimics the functionality of Linux's `wc` command, allowing you to count lines, words, and characters in text files.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Options](#options)
- [Examples](#examples)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

### Prerequisites

Before using My WC, make sure you have the following prerequisites installed:

- Java Development Kit (JDK) 8 or later
- Gradle(for building the project)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/nsharathchandra/wc.git
   ```
2. Build the project using Gradle:

   open "build.gradle.kts" as a new project in IDE that should build the project.

The project is now built and ready to use.

## Usage

You can run the WordCount (main class) through IDE by running the main class with the following arguments.
```agsl
"WordCount FILE_NAME"   gives words, characters and lines count
"WordCount FILE_NAME -w" gives the word count
"WordCount FILE_NAME -l" gives the lines count
"WordCount FILE_NAME -m" gives the character count 
"WordCount FILE_NAME -w -l" gives the word count and lines count
And so on...
```

Replace `[OPTIONS]` with the desired options, and `FILE` with the path to the text file you want to analyze.

## Options

My WC supports the following options:

- `-l`: Enable counting of lines.
- `-w`: Enable counting of words.
- `-m`: Enable counting of characters.

```bash
java -jar target/my-wc-1.0-SNAPSHOT.jar -l path/to/your/file.txt
```

Count words in a file:

```bash
java -jar target/my-wc-1.0-SNAPSHOT.jar -w path/to/your/file.txt
```

Count characters in a file:

```bash
java -jar target/my-wc-1.0-SNAPSHOT.jar -m path/to/your/file.txt
```

Count lines, words, and characters in a file:

```bash
java -jar target/my-wc-1.0-SNAPSHOT.jar -l -w -m path/to/your/file.txt
```

## Contributing

If you'd like to contribute to this project, feel free to open issues, submit pull requests, or provide feedback.

1. Fork the repository on GitHub.
2. Clone your fork locally.
3. Create a new branch for your feature or bug fix.
4. Make your changes and commit them.
5. Push your changes to your fork.
6. Create a pull request from your fork to the main repository.
