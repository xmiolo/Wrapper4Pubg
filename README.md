# Java Initial Wrapper for the official PUBG API
## Intro
This is a wrapper for [PlayerUnknown's BattleGround's API](https://developer.playbattlegrounds.com/) made in with Java.

Its not completed, but Players data still working

## Table of contents
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)

## Installation

    mvn clean install
    copy generated .jar to you project

## Usage

After installation, you can instantiate and set main values. 
```jav
PubgWrapper pubgWrapper = new PubgWrapper();

pubgWrapper.setApi_key("<API_KEY>");
pubgWrapper.setPlataform(PlataformEnum.PC_SA.getDescription());
```
With the module you can query the API and use the data models to manipulate the objects.


## Contributing

If you want to contribute, open a pull request. 
