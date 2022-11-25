# Drones task


#### simple Spring boot project to manage Drones missions and track battery levels 

## how to use 

like any Spring app you will need to build the mvn project 
or just run spring task from your IDE 

# build JAR / mvn command 
```
            mvn clean install -X
```

# API's 

- registering drone
    #### [POST] http://[server]/api/droans
     * play load JSON :
     ```
    {
    "weightlimit" : int ,
    "serial" : int,
    "model" : string ,
    "batteryCapacity" : int ,
    "state" : string
    }
    ```
     * example   [POST] http://localhost:8080/api/droans

     ```
   {
    "weightlimit" : 12 ,
    "serial" : 1212,
    "model" : "Lightweight" ,
    "batteryCapacity" : 100 ,
    "state" : "LOADING"
    }
    ```

    
    
    
    
- loading a drone with medication items 
  ### [POST] http://localhost:8080/api/drones-load
    * play load JSON :
  ```
  {
    "medication_id": [int] medication id   ,
    "drone_id" : [int] drone id
  }
  ```
    
  * example 
   ```
    {
      "medication_id": 1 ,
      "drone_id" : 1
    }
    ``` 
  
    it's return :
  ```
     {
       "error": false,
       "success": true,
       "massage": "transaction done successfully"
      }
   ```
- checking loaded medication items for a given drone 
  * [GET]  http://[server]/api/drone-load-info/[ID (int)]
    * example 
      * [GET]   http://localhost:8080/api/drone-load-info/1
      ```
      {
        "id": 1,
        "serial": 1000001,
        "model": "Lightweight",
        "weightlimit": 500,
        "batteryCapacity": 85,
        "state": "LOADED",
        "transactions": {
        "id": 1,
        "state": "LOADED",
        "dronsId": {
        "id": 1,
        "serial": 1000001,
        "model": "Lightweight",
        "weightlimit": 500,
        "batteryCapacity": 85,
        "state": "LOADED",
        "transactions": [],
        "battery": []
        },
        "medicationId": {
        "id": 1,
        "name": "MED 1",
        "code": "TM-1",
        "image": "path/file",
        "weight": 100,
        "transactions": []
        }
        }
        }
      ```
- checking available drones for loading
   
  
- check drone battery level for a given drone


- registering medication

