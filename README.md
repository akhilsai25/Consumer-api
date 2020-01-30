# Consumer-api

This project consumes data from a third party about per capita income of different communities in Chicago.

Reactivex programming is used to call an observer after the respose is received. Two threads are run using the Executors to seperate the data into two 
parts (Communities with per capita income greater than Chicago per capita income and other with less). The results are displayed on console.
