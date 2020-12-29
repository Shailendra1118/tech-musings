## Port kill
npx kill-port 5005 5006

# Brew
## install brew - 
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

## Start mongoDB 
brew services start mongodb-community

## Open connect
brew install openconnect
Connect to the docker machine
sudo openconnect --authgroup=Employee iceman.appdirect.com

sudo openconnect --authgroup=Employee batman.appdirect.com

## Setting bash aliases for vpn connect

alias vpn_bat="sudo openconnect --authgroup=Employee --user=first.last bat.xxx.com"
alias vpn_ice="sudo openconnect --authgroup=Employee --user=first.last  ice.xxx.com"


## GitHub
ssh-keygen -t rsa -b 4096 -C "first.last@xxx.com"
ssh-add -K ~/.ssh/id_rsa
cat ~/.ssh/id_rsa.pub (add this key to Github account)

# Java
## JDK
brew tap homebrew/cask-versions
brew cask install homebrew/cask-versions/adoptopenjdk8

## Install both JDK 8 and 11 versions
brew tap AdoptOpenJDK/openjdk
brew cask install adoptopenjdk11

export JAVA_8_HOME=$(/usr/libexec/java_home -v1.8)
export JAVA_11_HOME=$(/usr/libexec/java_home -v11)

alias java8='export JAVA_HOME=$JAVA_8_HOME'
alias java11='export JAVA_HOME=$JAVA_11_HOME'

- To make jdk11 default run : java11
