# Multifunctional VK Bot
## How to run aplication with docker
1. clone project
2. fill properties in (src/main/resources/application.properties)
    * vk.confirmation -- code for confimation
    * vk.access-token -- group's token
    * vk.api-version
3. execute follow commands:
    * docker build -t multifunctionalbot .   
    * docker run --publish 8080:8080 multifunctionalbot

