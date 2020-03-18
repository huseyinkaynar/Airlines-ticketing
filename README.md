# Airlines Ticketing System
[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

This code was written for an interview

## Used Technolojies

 - Java 8
  - Spring Boot
  - JPA Hibernate
  - PostgreSQL
  - Maven

### Structure of Spring Boot Project
```bash
├── Flightbooking.java
├── Controllers
│   ├── AirportController.java
│   ├── CompanyController.java
│   ├── FlightController.java
│   ├── RouteController.java
│   └── TicketController.java
├── Model
│   ├── Airport.java
│   ├── Company.java
│   ├── Flight.java
│   ├── Route.java
│   └── Ticket.java
├── Repositories
│   ├── AirportRepo.java
│   ├── CompanyRepo.java
│   ├── FlightRepo.java
│   ├── RouteRepo.java
│   └── TicketRepo.java
├── SearchQuery
│   └── SearchQueries.java
└── Services
  └── Impl
        ├── AirportServiceImpl.java
        ├── CompanyServiceImpl.java
        ├── FlightServiceImpl.java
        ├── RouteServiceImpl.java
        ├── TicketSellServiceImpl.java
        └── TicketServiceImpl.java
    ├── AirportService.java
    ├── CompanyService.java
    ├── FlightService.java
    ├── RouteService.java
    ├── TicketSellService.java
    ├── TicketService.java
    
```

### How Using the System 
--------

##### Airports,Routes,Flights,Companies Requests

  - You can get airports,routes,flights,companies with requests like this:
```sh
    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Airport>> getAllAirport() {
        return new ResponseEntity<>(airportService.allAirport(), HttpStatus.OK);
    }
```
 - You can create tables with requests like this:
```sh
    @PostMapping("")
    public String postRoute(@RequestBody Route route){
        routeService.saveRoute(route);
        return "saved";
    }
```

  - You can search airports or companies by name with searching request like this:
```sh
    @GetMapping("/search")
    @ResponseBody
    public ResponseEntity<List<Airport>> searchAirport(@RequestParam(value = "airport_name") String airport) {
        return new ResponseEntity<>(airportService.getSearchAirport(airport), HttpStatus.OK);
    }
```

##### Tickets Requests

  - You can sell ticket with requests like this:
```sh
   @PostMapping(value = "/sell")
    public ResponseEntity<String> purchase(@RequestBody Ticket ticket) {
        ticketSellService.sellTicket(ticket);
        return new ResponseEntity<>("ticket sell", HttpStatus.OK);
    }
```

  - You can cancel ticket with requests like this:
```sh
    @PutMapping("/cancelticket/{id}")
    public ResponseEntity<String> cancel(@PathVariable  Long id,@RequestBody Ticket ticket){
        ticketSellService.cancelTicket(id,ticket);
        return new ResponseEntity<>("ticket gone", HttpStatus.OK);
    }
```

### Postman Requests    
--------
##### GET localhost:8082/airport
```bash
[
    {
        "id": 1,
        "airportName": "Sabiha Gökçen",
        "airportShortName": "SAW",
        "airportLocation": "İstanbul"
    },
    {
        "id": 2,
        "airportName": "Atatürk",
        "airportShortName": "ATA",
        "airportLocation": "İstanbul"
    },
    {
        "id": 3,
        "airportName": "Esenboğa",
        "airportShortName": "ESN",
        "airportLocation": "Ankara"
    },
    {
        "id": 4,
        "airportName": "Erhaç",
        "airportShortName": "MLX",
        "airportLocation": "Malatya"
    },
    {
        "id": 5,
        "airportName": "Marco Polo ",
        "airportShortName": "MAP",
        "airportLocation": "Venedik"
    }
]
```
##### GET localhost:8082/company
```bash
[
    {
        "id": 1,
        "companyName": "Pegasus"
    },
    {
        "id": 2,
        "companyName": "THY"
    },
    {
        "id": 3,
        "companyName": "FlyEmirates"
    },
    {
        "id": 4,
        "companyName": "SunExpress"
    },
    {
        "id": 5,
        "companyName": "Onur Air"
    }
]
```
##### GET localhost:8082/route
```bash
[
    {
        "id": 1,
        "originAirport": {
            "id": 1,
            "airportName": "Sabiha Gökçen",
            "airportShortName": "SAW",
            "airportLocation": "İstanbul"
        },
        "destAirport": {
            "id": 4,
            "airportName": "Erhaç",
            "airportShortName": "MLX",
            "airportLocation": "Malatya"
        }
    },
    {
        "id": 2,
        "originAirport": {
            "id": 3,
            "airportName": "Esenboğa",
            "airportShortName": "ESN",
            "airportLocation": "Ankara"
        },
        "destAirport": {
            "id": 2,
            "airportName": "Atatürk",
            "airportShortName": "ATA",
            "airportLocation": "İstanbul"
        }
    },
    {
        "id": 3,
        "originAirport": {
            "id": 2,
            "airportName": "Atatürk",
            "airportShortName": "ATA",
            "airportLocation": "İstanbul"
        },
        "destAirport": {
            "id": 4,
            "airportName": "Erhaç",
            "airportShortName": "MLX",
            "airportLocation": "Malatya"
        }
    },
    {
        "id": 4,
        "originAirport": {
            "id": 4,
            "airportName": "Erhaç",
            "airportShortName": "MLX",
            "airportLocation": "Malatya"
        },
        "destAirport": {
            "id": 5,
            "airportName": "Marco Polo ",
            "airportShortName": "MAP",
            "airportLocation": "Venedik"
        }
    }
]
```
##### GET localhost:8082/flight
```bash
[
    {
        "id": 1,
        "route": {
            "id": 2,
            "originAirport": {
                "id": 3,
                "airportName": "Esenboğa",
                "airportShortName": "ESN",
                "airportLocation": "Ankara"
            },
            "destAirport": {
                "id": 2,
                "airportName": "Atatürk",
                "airportShortName": "ATA",
                "airportLocation": "İstanbul"
            }
        },
        "company": {
            "id": 1,
            "companyName": "Pegasus"
        },
        "startPrice": "1000",
        "date": "2020-12-11 09:50:00",
        "numberOfTicket": 150,
        "soldTicket": 25
    },
    {
        "id": 3,
        "route": {
            "id": 1,
            "originAirport": {
                "id": 1,
                "airportName": "Sabiha Gökçen",
                "airportShortName": "SAW",
                "airportLocation": "İstanbul"
            },
            "destAirport": {
                "id": 4,
                "airportName": "Erhaç",
                "airportShortName": "MLX",
                "airportLocation": "Malatya"
            }
        },
        "company": {
            "id": 4,
            "companyName": "SunExpress"
        },
        "startPrice": "500",
        "date": "2020-12-09 09:50:00",
        "numberOfTicket": 200,
        "soldTicket": 123
    },
    {
        "id": 4,
        "route": {
            "id": 4,
            "originAirport": {
                "id": 4,
                "airportName": "Erhaç",
                "airportShortName": "MLX",
                "airportLocation": "Malatya"
            },
            "destAirport": {
                "id": 5,
                "airportName": "Marco Polo ",
                "airportShortName": "MAP",
                "airportLocation": "Venedik"
            }
        },
        "company": {
            "id": 4,
            "companyName": "SunExpress"
        },
        "startPrice": "1200",
        "date": "2010-02-23 10:50:00",
        "numberOfTicket": 120,
        "soldTicket": 40
    },
    {
        "id": 2,
        "route": {
            "id": 3,
            "originAirport": {
                "id": 2,
                "airportName": "Atatürk",
                "airportShortName": "ATA",
                "airportLocation": "İstanbul"
            },
            "destAirport": {
                "id": 4,
                "airportName": "Erhaç",
                "airportShortName": "MLX",
                "airportLocation": "Malatya"
            }
        },
        "company": {
            "id": 3,
            "companyName": "FlyEmirates"
        },
        "startPrice": "2000",
        "date": "2020-10-11 09:50:00",
        "numberOfTicket": 100,
        "soldTicket": 10
    }
]
```
##### GET localhost:8082/ticket
```bash
[
    {
        "id": 1,
        "name": "Hüseyin",
        "surname": "Kaynar",
        "price": "1000",
        "flight": {
            "id": 1,
            "route": {
                "id": 2,
                "originAirport": {
                    "id": 3,
                    "airportName": "Esenboğa",
                    "airportShortName": "ESN",
                    "airportLocation": "Ankara"
                },
                "destAirport": {
                    "id": 2,
                    "airportName": "Atatürk",
                    "airportShortName": "ATA",
                    "airportLocation": "İstanbul"
                }
            },
            "company": {
                "id": 1,
                "companyName": "Pegasus"
            },
            "startPrice": "1000",
            "date": "2020-12-11 09:50:00",
            "numberOfTicket": 150,
            "soldTicket": 25
        }
    },
    {
        "id": 2,
        "name": "Mehmet",
        "surname": "Kaynar",
        "price": "1500",
        "flight": {
            "id": 3,
            "route": {
                "id": 1,
                "originAirport": {
                    "id": 1,
                    "airportName": "Sabiha Gökçen",
                    "airportShortName": "SAW",
                    "airportLocation": "İstanbul"
                },
                "destAirport": {
                    "id": 4,
                    "airportName": "Erhaç",
                    "airportShortName": "MLX",
                    "airportLocation": "Malatya"
                }
            },
            "company": {
                "id": 4,
                "companyName": "SunExpress"
            },
            "startPrice": "500",
            "date": "2020-12-09 09:50:00",
            "numberOfTicket": 200,
            "soldTicket": 123
        }
    },
    {
        "id": 3,
        "name": "Ahmet",
        "surname": "aydın",
        "price": "400",
        "flight": {
            "id": 3,
            "route": {
                "id": 1,
                "originAirport": {
                    "id": 1,
                    "airportName": "Sabiha Gökçen",
                    "airportShortName": "SAW",
                    "airportLocation": "İstanbul"
                },
                "destAirport": {
                    "id": 4,
                    "airportName": "Erhaç",
                    "airportShortName": "MLX",
                    "airportLocation": "Malatya"
                }
            },
            "company": {
                "id": 4,
                "companyName": "SunExpress"
            },
            "startPrice": "500",
            "date": "2020-12-09 09:50:00",
            "numberOfTicket": 200,
            "soldTicket": 123
        }
    },
    {
        "id": 4,
        "name": "Kadir",
        "surname": "Alkan",
        "price": "760",
        "flight": {
            "id": 3,
            "route": {
                "id": 1,
                "originAirport": {
                    "id": 1,
                    "airportName": "Sabiha Gökçen",
                    "airportShortName": "SAW",
                    "airportLocation": "İstanbul"
                },
                "destAirport": {
                    "id": 4,
                    "airportName": "Erhaç",
                    "airportShortName": "MLX",
                    "airportLocation": "Malatya"
                }
            },
            "company": {
                "id": 4,
                "companyName": "SunExpress"
            },
            "startPrice": "500",
            "date": "2020-12-09 09:50:00",
            "numberOfTicket": 200,
            "soldTicket": 123
        }
    }
]
```
### More Info
------
- For more info, do not hesitate to contact me!
