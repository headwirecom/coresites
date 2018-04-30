# Coresites

Coresites is a set of AEM components designed to allow rapid webpage creation without the need for custom development. Users can quickly create professional-looking pages using the Coresites template and components and the AEM grid & style systems.

## Requirements

Coresites is designed for Adobe AEM Version 6.4

Apache Maven is required to build the project yourself (version 3.5+ recommended) 

## Documentation

[View the coresites component documentation on the GitHub project wiki.](https://github.com/headwirecom/coresites/wiki/Coresites-Components)

## Installation

### Install from a package

Todo: Fill this in when the release packages are built

### Install with Maven

1. Clone this repository with Git:

	```
	git clone https://github.com/headwirecom/coresites.git
	```
2. From the root directory, run the following Maven commands:
	* To install Coresites
	```
	mvn -PautoInstallPackage clean install
	```
	* To install the sample Coresites content
	```
	mvn -PautoInstallContentPackage clean install
	```

## Specifying CRX Host/Port

The CRX host and port can be specified on the command line with:
mvn -Dcrx.host=otherhost -Dcrx.port=5502 <goals>


