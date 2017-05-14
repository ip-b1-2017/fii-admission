$(function () {
    $("#myform").dform({
        "action":"http://localhost:8090/form",
        "method": "post",
        "html": [{
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input",
                                "html": [{
                                        "name": "initial-name-alfa",
                                        "caption": "Nume de familie la nastere",
                                        "type": "text",
                                        "placeholder": "Ex. Apopei",
                                        "class": "form-control"
                                    }

                                ]
                            },
                            {
                                "type": "p",
                                "class": "bg-info",
                                "html": "Din certificatul de naştere "
                            }
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "parent-initial-alfa",
                                "caption": "Initiala tatalui/mamei",
                                "type": "text",
                                "maxlength": "1",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input",
                                "html": [{
                                        "name": "actual-name-alfa",
                                        "caption": "Nume de familie actual",
                                        "type": "text",
                                        "placeholder": "Ex. Mihaila",
                                        "class": "form-control"
                                    },

                                ]
                            },
                            {
                                "type": "p",
                                "class": "bg-info",
                                "html": "După căsătorie, înfiere, modificare la cerere conform actului doveditor, dacă este cazul"
                            }
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "prenume-alfa",
                                "caption": "Prenume candidat",
                                "type": "text",
                                "placeholder": "Ex. Ioana Maria",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input",
                                "html": [{
                                        "name": "mother-name-alfa",
                                        "caption": "Prenumele mamei",
                                        "type": "text",
                                        "placeholder": "Ex. Mihaila",
                                        "class": "form-control"
                                    },

                                ]
                            },
                            {
                                "type": "p",
                                "class": "bg-info",
                                "html": "Din certificatul de nastere al candidatului"
                            },
                        ]
                    },
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input",
                                "html": [{
                                        "name": "father-name-alfa",
                                        "caption": "Prenumele tatalui",
                                        "type": "text",
                                        "placeholder": "Ex. Andrei",
                                        "class": "form-control"
                                    },

                                ]
                            },
                            {
                                "type": "p",
                                "class": "bg-info",
                                "html": "Din certificatul de nastere al candidatului"
                            },
                        ]
                    }

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "initial-name",
                                    "caption": "CNP-num",
                                    "type": "text",
                                    "placeholder": "2780923232",
                                    "class": "form-control",
                                    "maxlength": "13"
                                }

                            ]
                        }, ]
                    },

                    {
                        "type": "div",

                        "class": "custom-input",
                        "html": [{
                                "name": "sex-alfa",
                                "type": "select",
                                "class": "form-control",
                                "caption": "Sex",
                                "options": {
                                    "fe": "Feminin",
                                    "ma": "Masculin",
                                    "ot": "Other"
                                }
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "birth-date",
                                    "caption": "Data Nasterii",
                                    "type": "text",
                                    "class": "form-control"
                                }

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input",
                                "html": [{
                                        "name": "birth-country-alfa",
                                        "caption": "Tara",
                                        "type": "text",
                                        "class": "form-control"
                                    }

                                ]
                            },
                            {
                                "type": "p",
                                "class": "bg-info",
                                "html": "Din certificatul de nastere al candidatului"
                            },
                        ]
                    }

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input",
                                "html": [{
                                        "name": "birth-county-alfa",
                                        "caption": "Judetul",
                                        "type": "text",
                                        "class": "form-control",
                                        "placeholder": "Ex. Iasi"

                                    }

                                ]
                            },
                            {
                                "type": "p",
                                "class": "bg-info",
                                "html": "Din certificatul de nastere al candidatului"
                            }
                        ]
                    },

                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input",
                                "html": [{
                                        "name": "birth-city-alfa",
                                        "caption": "Orasul",
                                        "type": "text",
                                        "class": "form-control",
                                        "placeholder": "Ex. Iasi"

                                    }

                                ]
                            },
                            {
                                "type": "p",
                                "class": "bg-info",
                                "html": "Din certificatul de nastere al candidatului"
                            }
                        ]
                    }

                ]
            },
             {
                "type": "div",
                "class": "form-group",
                "html": [
                    {
                        "type": "div",

                        "class": "custom-input",
                        "html": [{
                                "name": "stare-civila",
                                "type": "select",
                                "class": "form-control",
                                "caption": "Starea civila",
                                "options": {
                                    "cas": "Casatorit(a)",
                                    "necas": "Necasatorit(a)",
                                    "divor": "Divortat(a)/Vaduv(a)"
                                }
                            }

                        ]
                    }                 
                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [
                   {
                        "type": "div",

                        "class": "custom-input",
                        "html": [{
                                "name": "tip-act-identitate",
                                "type": "select",
                                "class": "form-control",
                                "caption": "Tipul actului de identitate",
                                "options": {
                                    "ci": "CI",
                                    "pas": "Pasaport"
                                }
                            }

                        ]
                    },
                      {
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "serie-act-alfa",
                                    "caption": "Seria ",
                                    "type": "text",
                                    "placeholder": "Ex. MZ",
                                    "class": "form-control"
                                },

                            ]
                        }

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "act-number-num",
                                    "caption": "Numarul ",
                                    "type": "text",
                                    "placeholder": "Ex. MZ",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "act-elibeat-alfn",
                                "caption": "Eliberat de",
                                "type": "text",
                                "placeholder": "Ex. SPCLEP Iasi",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
               {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "act-elib-date",
                                    "caption": "Data eliberarii ",
                                    "type": "text",
                                    "placeholder": "Ex. 25.02.2016",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "act-exp-date",
                                "caption": "Data expirarii",
                                "type": "text",
                                "placeholder": "Ex. 25.02.2020",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type":"h4",
                "html":"Domiciliu actual stabil"
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [ {
                        "type": "div",

                        "class": "custom-input",
                        "html": [{
                                "name": "domiciliu-stabil",
                                "type": "select",
                                "class": "form-control",
                                "caption": "Domiciliu stabil",
                                "options": {
                                    "urb": "Urban",
                                    "rur": "Rural"
                                }
                            }

                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "domiciliu-tara-alfa",
                                "caption": "Tara",
                                "type": "text",
                                "placeholder": "Ex. Romania",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
             {
                "type": "div",
                "class": "form-group",
                "html": [
                    {
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "domiciliu-judet-alfa",
                                    "caption": "Judetul ",
                                    "type": "text",
                                    "placeholder": "Ex. Iasi",
                                    "class": "form-control"
                                },

                            ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "domiciliu-loc-alfa",
                                "caption": "Localitatea",
                                "type": "text",
                                "placeholder": "Ex. Iasi",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [
                    {
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "domiciliu-strada-alfnum",
                                    "caption": "Strada ",
                                    "type": "text",
                                    "placeholder": "Ex. Plopilor",
                                    "class": "form-control"
                                },

                            ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "domiciliu-nr-num",
                                "caption": "Numarul",
                                "type": "number",
                                "placeholder": "Ex. 25",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [
                    {
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "domiciliu-bloc-alfnum",
                                    "caption": "Bloc ",
                                    "type": "text",
                                    "placeholder": "Ex. C7",
                                    "class": "form-control"
                                },

                            ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "domiciliu-sc-alfnum",
                                "caption": "Scara",
                                "type": "number",
                                "placeholder": "Ex. B",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [
                    {
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "domiciliu-et-alfnum",
                                    "caption": "Etaj ",
                                    "type": "text",
                                    "placeholder": "Ex. 5",
                                    "class": "form-control"
                                },

                            ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "domiciliu-ap",
                                "caption": "Apartament",
                                "type": "number",
                                "placeholder": "Ex. 7",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [
                    {
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "domiciliu-cod-alfnum",
                                    "caption": "Cod ",
                                    "type": "text",
                                    "placeholder": "Ex.700340",
                                    "class": "form-control"
                                },

                            ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "phone",
                                "caption": "Telefon",
                                "type": "number",
                                "placeholder": "Ex. 0741542032",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [
                    {
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "email",
                                    "caption": "Email ",
                                    "type": "text",
                                    "placeholder": "Ex. user@gmail.com",
                                    "class": "form-control"
                                }

                            ]
                    }

                  

                ]
            }
        ]
    });
});


$(function () {
    $("#myform2").dform({
        "action": "http://localhost:8090/form",
        "method": "post",
        "html": [{
                "type": "h4",
                "html": " II.a. Studiile preuniversitare absolvite, nivel liceu",
                "class": "sub-title"
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "graduate-institution-alfn",
                                    "caption": "Instituţia unde a absolvit ",
                                    "type": "text",
                                    "placeholder": "Ex. Liceul Teoretic de Informatică \"Grigore Moisil\"",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "graduate-country-alfa",
                                "caption": "Țara",
                                "type": "text",
                                "placeholder": "Ex. România",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "graduate-town-alfa",
                                    "caption": "Localitatea",
                                    "type": "text",
                                    "placeholder": "Ex. Iași",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "graduate-county-alfa",
                                "caption": "Județul",
                                "type": "text",
                                "placeholder": "Ex. Iași",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "graduate-field-alfa",
                                    "caption": "Profilul/Domeniul",
                                    "type": "text",
                                    "placeholder": "Ex. Matematică-Informatică",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "length-of-studies-num",
                                "caption": "Durata studiilor",
                                "type": "number",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "graduation-year-num",
                                    "caption": "Anul absolvirii",
                                    "type": "number",
                                    "min": "1950",
                                    "max": "2015",
                                    "placeholder": "Ex. 2010",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input-row",

                        "html": [{
                                "type": "div",
                                "caption": "Forma de invatamant",
                                "class": "custom-section",
                                "html": [{
                                    "name": "education-form-alfa",

                                    "type": "radiobuttons",
                                    "class": "radio-inline",
                                    "options": {
                                        "zi": "Zi"
                                    }
                                }]

                            },
                            {
                                "type": "div",
                                "class": "custom-section",
                                "html": [{
                                    "name": "education-form-alfa",

                                    "type": "radiobuttons",
                                    "class": "radio-inline",
                                    "options": {
                                        "ser": "Seral"
                                    }
                                }]

                            },
                            {
                                "type": "div",
                                "class": "custom-section",
                                "html": [{
                                    "name": "education-form-alfa",

                                    "type": "radiobuttons",
                                    "class": "radio-inline",
                                    "options": {
                                        "fr": "FR"
                                    }
                                }]

                            },
                            {
                                "type": "div",
                                "class": "custom-section",
                                "html": [{
                                    "name": "education-form-alfa",

                                    "type": "radiobuttons",
                                    "class": "radio-inline",
                                    "options": {
                                        "ip": "IP"
                                    }
                                }]

                            }

                        ]
                    }

                ]
            },
            {
                "type": "h4",
                "html": "Diploma de bacalaureat",
                "class": "sub-title"
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "bac-series-alfn",
                                    "caption": "Seria",
                                    "type": "text",
                                    "placeholder": "Ex. n2s90",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "bac-num",
                                "caption": "Numarul",
                                "type": "number",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "issued-by-alfnum",
                                    "caption": "Emisă de",
                                    "type": "text",
                                    "placeholder": "Ex. n2s90",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "bac-number-date",
                                "caption": "Data emiterii",
                                "type": "text",
                                "placeholder": "Ex. 21.04.2016",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "nr-foaie-matricola-alfnum",
                                    "caption": "Numărul foii matricole care însoțește actul de studii",
                                    "type": "text",
                                    "placeholder": "Ex. ncc32s90",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },


                ]
            },
            {
                "type": "h4",
                "html": "Alte observaţii (pentru cazurile în care candidatul a absolvit studiile anterioare în străinătate)",
                "class": "sub-title"
            },
            {
                "type": "h4",
                "html": "Act de recunoaştere/ echivalare (eliberat de DPIRP/CNRED)",
                "class": "sub-title"
            },
            {

                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "nr-echivalare-num",
                                    "caption": "Număr",
                                    "type": "number",
                                    "placeholder": "Ex. 12353",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "serie-echivalare-alfnum",
                                "caption": "Serie",
                                "type": "text",
                                "placeholder": "Ex. w6346",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "echivalare-date",
                                    "caption": "Data echivalării",
                                    "type": "date",
                                    "placeholder": "Ex. 21.04.20016",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },


                ]
            },
            {
                "type": "h4",
                "html": "II.b. Studiile universitare în curs/ absolvite",
                "class": "sub-title"
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                        "type": "div",
                        "class": "custom-input-row",
                        "html": [{
                                "name": "absolvent-licenta-diploma-alfa",
                                "type": "radiobuttons",
                                "options": {
                                    "cu": "Sunt student la alta facultate",
                                    "fara": "Nu sunt student la alta facultate",

                                },


                            }

                        ]
                    } ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "tara-alte-studii-alfa",
                                "caption": "Țara",
                                "type": "text",
                                "placeholder": "Ex. Franța",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "alte-studii-localitate-alfa",
                                    "caption": "Localitatea",
                                    "type": "text",
                                    "placeholder": "Ex. Paris",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "alte-studii-judetul-alfa",
                                "caption": "Județul",
                                "type": "text",
                                "placeholder": "Ex. Paris",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "alte-studii-institutie-alfn",
                                    "caption": "Denumirea instituţiei de învăţământ superior  ",
                                    "type": "text",
                                    "placeholder": "Ex. ",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "alte-studii-facultatea-alfn",
                                "caption": "Facultatea",
                                "type": "text",
                                "placeholder": "Ex. ",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "alte-studii-domeniu-licenta-alfa",
                                    "caption": "Domeniul de licenţă  ",
                                    "type": "text",
                                    "placeholder": "Ex. ",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "alte-studii-specializarea-alfa",
                                "caption": "Programul de studii /Specializarea",
                                "type": "text",
                                "placeholder": "Ex.",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [
                    {
                        "type": "div",
                        "class": "custom-input-row",

                        "html": [{
                                "type": "div",
                                "caption": "Forma de invatamant",
                                "class": "custom-section",
                                "html": [{
                                    "name": "education-form-alfa",

                                    "type": "radiobuttons",
                                    "class": "radio-inline",
                                    "options": {
                                        "zi": "Zi"
                                    }
                                }]

                            },
                            {
                                "type": "div",
                                "class": "custom-section",
                                "html": [{
                                    "name": "education-form-alfa",

                                    "type": "radiobuttons",
                                    "class": "radio-inline",
                                    "options": {
                                        "ser": "Seral"
                                    }
                                }]

                            },
                            {
                                "type": "div",
                                "class": "custom-section",
                                "html": [{
                                    "name": "education-form-alfa",

                                    "type": "radiobuttons",
                                    "class": "radio-inline",
                                    "options": {
                                        "fr": "FR"
                                    }
                                }]

                            },
                            {
                                "type": "div",
                                "class": "custom-section",
                                "html": [{
                                    "name": "education-form-alfa",

                                    "type": "radiobuttons",
                                    "class": "radio-inline",
                                    "options": {
                                        "ip": "IP"
                                    }
                                }]

                            }

                        ]
                    },


                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "alte-studii-anul-num",
                                "caption": "Anul",
                                "type": "number",
                                "placeholder": "Ex. 2000",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "alte-studii-semestre-la-buget-num",
                                    "caption": "Numărul semestrelor finanţate de la bugetul de stat",
                                    "type": "number",
                                    "placeholder": "Ex. ",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "alte-studii-semestre-la-bursa-num",
                                "caption": "Numărul semestrelor în care aţi beneficiat de bursă ",
                                "type": "number",
                                "placeholder": "Ex.",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "h4",
                "html": "Absolvent al studiilor de licenţă ",
                "class": "sub-title"
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "absolvent-licenta-an-num",
                                    "caption": "Anul",
                                    "type": "number",
                                    "placeholder": "Ex. ",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input-row",
                        "html": [{
                                "name": "absolvent-licenta-diploma-alfa",
                                "type": "radiobuttons",
                                "options": {
                                    "cu": "Fără diplomă de licenţă",
                                    "fara": "Cu diplomă de licenţă",

                                },


                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "abslovent-licenta-tara-alfa",
                                    "caption": "Țara",
                                    "type": "text",
                                    "placeholder": "Ex. ",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "absolvett-licenta-localitatea-alfa",
                                "caption": "Localitate",
                                "type": "text",
                                "placeholder": "Ex. ",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "abslovent-licenta-judet-alfa",
                                    "caption": "Județul",
                                    "type": "text",
                                    "placeholder": "Ex. ",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "absolvett-licenta-institutie-alfa",
                                "caption": "Denumirea instituţiei de învăţământ superior  ",
                                "type": "text",
                                "placeholder": "Ex. ",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "abslovent-licenta-facultate-alfnum",
                                    "caption": "Facultatea",
                                    "type": "text",
                                    "placeholder": "Ex. ",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "absolvett-licenta-domeniu-licenta-alfa",
                                "caption": "Domeniul de licenţă",
                                "type": "text",
                                "placeholder": "Ex. ",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "abslovent-licenta-specializare-alfa",
                                    "caption": "Programul de studii /Specializarea ",
                                    "type": "text",
                                    "placeholder": "Ex. ",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "absolvett-licenta-titlu-alfa",
                                "caption": "Titlul obţinut ",
                                "type": "text",
                                "placeholder": "Ex. ",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [
                    {
                        "type": "div",
                        "class": "custom-input-row",

                        "html": [{
                                "type": "div",
                                "caption": "Forma de invatamant",
                                "class": "custom-section",
                                "html": [{
                                    "name": "education-form-alfa",

                                    "type": "radiobuttons",
                                    "class": "radio-inline",
                                    "options": {
                                        "zi": "Zi"
                                    }
                                }]

                            },
                            {
                                "type": "div",
                                "class": "custom-section",
                                "html": [{
                                    "name": "education-form-alfa",

                                    "type": "radiobuttons",
                                    "class": "radio-inline",
                                    "options": {
                                        "ser": "Seral"
                                    }
                                }]

                            },
                            {
                                "type": "div",
                                "class": "custom-section",
                                "html": [{
                                    "name": "education-form-alfa",

                                    "type": "radiobuttons",
                                    "class": "radio-inline",
                                    "options": {
                                        "fr": "FR"
                                    }
                                }]

                            },
                            {
                                "type": "div",
                                "class": "custom-section",
                                "html": [{
                                    "name": "education-form-alfa",

                                    "type": "radiobuttons",
                                    "class": "radio-inline",
                                    "options": {
                                        "ip": "IP"
                                    }
                                }]

                            }

                        ]
                    },


                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "alte-studii-anul-num",
                                "caption":"Nu marul semestrelor finantate de bugetul de stat",
                                "type": "number",
                                "placeholder": "Ex.3 ",
                                "class": "form-control"
                            }

                        ]
                    }

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "abslovent-licenta-semestre-bursa-num",
                                    "caption": "Numărul semestrelor în care aţi beneficiat de bursă",
                                    "type": "number",
                                    "placeholder": "Ex. ",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "absolvett-licenta-durata-studii-num",
                                "caption": "Durata studiilor (număr de ani)  ",
                                "type": "number",
                                "placeholder": "Ex. 4",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "h4",
                "html": "Diploma de licenţă:",
                "class": "sub-title"
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "abslovent-licenta-diploma-seria-alfn",
                                    "caption": "Seria",
                                    "type": "text",
                                    "placeholder": "Ex. ",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "absolvett-licenta-diploma-num",
                                "caption": "Număr",
                                "type": "text",
                                "placeholder": "Ex. ",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "abslovent-licenta-diploma-emisade-alfa",
                                    "caption": "Emisă de ",
                                    "type": "text",
                                    "placeholder": "Ex. ",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "absolvett-licenta-diploma-date",
                                "caption": "Data emiterii",
                                "type": "text",
                                "placeholder": "Ex. ",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "absolvent-licenta-diploma-nr-supliment-alfn",
                                    "caption": "Numărul suplimentului / foii matricole care însoțește actul de studii",
                                    "type": "text",
                                    "placeholder": "Ex. ncc32s90",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },


                ]
            },
            {
                "type": "h4",
                "html": "Alte observaţii (pentru cazurile în care candidatul a absolvit studiile anterioare în străinătate)",
                "class": "sub-title"
            },
            {
                "type": "h4",
                "html": "Act de recunoaştere/ echivalare (eliberat de DPIRP/CNRED)",
                "class": "sub-title"
            },
            {

                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "nr-echivalare-num",
                                    "caption": "Număr",
                                    "type": "num",
                                    "placeholder": "Ex. 12353",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "serie-echivalare-alfn",
                                "caption": "Serie",
                                "type": "text",
                                "placeholder": "Ex. w6346",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "data-echivalare-date",
                                    "caption": "Data echivalării",
                                    "type": "date",
                                    "placeholder": "Ex. 21.04.2016",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },


                ]
            },


        ]
    });
});

$(function () {
    $("#myform3").dform({
        "action": "http://localhost:8090/form",
		"method": "post",
        "html": [{
                "type": "h4",
                "html": "III. Cerinţe specifice facultăţii",
                "class": "sub-title"
            },
            {

                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "media-bac-num",
                                    "caption": "Media generală la examenul de bacalaureat",
                                    "type": "text",
                                    "placeholder": "Ex. 8.90",
                                    "class": "form-control"
                                },

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "media-mate/info-num",
                                "caption": "Media la disciplina mate/info (maxima)",
                                "type": "text",
                                "placeholder": "Ex. 9.40",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                        "type": "div",

                        "class": "custom-input",
                        "html": [{
                                "name": "option-test",
                                "type": "select",
                                "class": "form-control",
                                "caption": "Optiunea pentru testul scris",
                                "options": {
                                    "mate": "Matematica",
                                    "info1": "Informatica (Pascal)",
                                    "info2": "Informatica (C)"
                                }
                            }

                        ]
                    } ]
                    },{
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                        "type": "div",

                        "class": "custom-input",
                        "html": [{
                                "name": "option-test",
                                "type": "select",
                                "class": "form-control",
                                "caption": "Solicitati echivalare cu diploma la olimpiada organizata MEN?",
                                "options": {
                                    "da": "Da",
                                    "nu": "Nu"
                                }
                            }

                        ]
                    } ]
                    }


                ]
            },
              {
                "type": "div",
                "class": "form-group",
                "html": [

                          {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                        "type": "div",

                        "class": "custom-input",
                        "html": [{
                                "name": "option-test",
                                "type": "select",
                                "class": "form-control",
                                "caption": "Ați participat la preadmitere la Facultatea de Informatică din Iași și doriți luarea în considerare a notei la examenul din sesiunea curentă?",
                                "options": {
                                    "da": "Da",
                                    "nu": "Nu"
                                }
                            }

                        ]
                    } ]
                },
                {

                                "type": "div",
                                "class": "custom-input",
                                "html": [{
                                        "name": "an-preadmitere-num",
                                        "caption": "Dacă da, în ce an?",
                                        "type": "number",
                                        "placeholder": "Ex. 2015",
                                        "class": "form-control"
                                    },

                                ]
                            }
                
     
                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [

                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                        "type": "div",

                        "class": "custom-input",
                        "html": [{
                                "name": "option-test",
                                "type": "select",
                                "class": "form-control",
                                "caption": "Daca ati raspuns DA la intrebarea anterioara, doriti sa sustineti din nou testul scris in aceasta sesiune de admitere**?",
                                "options": {
                                    "da": "Da",
                                    "nu": "Nu"
                                }
                            }

                        ]
                    } ]
                },

                ]
            },
            {
                "type": "div",
                "html": [

                    {
                        "type": "div",
                        "html": [{
                            "name": "cerinte-facultate-info",
                            "type": "p",
                            "html": "*opțiune valabilă la o singură sesiune de admitere",
                            "class": "info"
                        }, ]
                    },

                ]
            },
            {
                "type": "div",
                "html": [

                    {
                        "type": "div",
                        "html": [{
                            "name": "cerinte-facultate-info",
                            "type": "p",
                            "html": "** în acest caz, va luată în considerare nota cea mai mare",
                            "class": "info"
                        }, ]
                    },

                ]
            },


        ]
    });
});

$(function () {
    $("#myform4").dform({
        "action": "http://localhost:8090/form",
		"method": "post",
        "html": [{
                "type": "h4",
                "html": "IV. Opţiuni de admitere, în ordinea preferinţelor",
                "class": "sub-title"
            },



        ]
    });
});
$(function () {
    $("#myform6").dform({
        "action": "http://localhost:8090/form",
		"method": "post",
        "html": [
            {
                "type": "h4",
                "html": "Taxe:",
                "class": "sub-title"
            },
            {
                "type":"ul",
                "html":[
                    {
                        "type":"li",
                        "html":"Taxă de înscriere: 300 Ron"
                    },
                       {
                        "type":"li",
                        "html":"Taxă de şcolarizare: 3500 Ron"
                    }
                ]
            },
            {
                "type": "h4",
                "html": "Acte necesare:",
                "class": "sub-title"
            },
            {
                "type":"ul",
                "html":[
                    {
                        "type":"li",
                        "html":"fişa de înscriere"
                    },
                    {
                        "type":"li",
                        "html":"trei fotografii tip buletin de identitate"
                    },
                    {
                        "type":"li",
                        "html":"diploma de bacalaureat sau echivalentă cu aceasta, recunoscută de M.E.N."
                    },
                    {
                        "type":"ul",
                        "html":[
                            {
                                "type":"li",
                                "html":"candidaţii care au promovat examenul de bacalaureat în sesiunea iunie-iulie 2016 pot prezenta la înscriere, în locul diplomei de bacalaureat, adeverinţa eliberată de liceu, în care se menţionează atât media generală, cât şi notele obţinute la probele susţinute şi notele la disciplinele care se iau în calcul la stabilirea mediei"
                            },
                            {
                                "type":"li",
                                "html":"dacă un candidat nu depune la o specializare diploma în original, va depune şi o adeverinţă de la facultatea unde are actele în original"
                            }
                        ]
                    },
                    {
                        "type":"li",
                        "html":"certificat de naştere, în copie legalizată"
                    },
                    {
                        "type":"li",
                        "html":"certificatul de căsătorie sau documentul care atestă schimbarea numelui, în copie legalizată (dacă este cazul)"
                    },
                    {
                        "type":"li",
                        "html":"copie după cartea de identitate, care atestă domiciliul în România"
                    },
                    {
                        "type":"li",
                        "html":"adeverinţă medicală tip"
                    },
                    {
                        "type":"li",
                        "html":"chitanţă care dovedeşte plata taxei de înscriere sau actele necesare pentru scutirea de plata taxei"
                    },
                    {
                        "type":"li",
                        "html":"dosar plic"
                    }
                ]
            },
            {
                "type":"p",
                "html":"Candidaţii cetăţeni români cu domiciliul în România, dar cu studii efectuate în străinătate (inclusiv Republica Moldova) vor prezenta la înscriere diploma de bacalaureat echivalată de către Ministerul Educaţiei Naţionale (CNRED)."
            },
            {
                "type": "h4",
                "html": "Candidaţii care au absolvit liceul inainte de 2016 vor depune la dosar, după caz:",
                "class": "sub-title"
            },
            {
                "type":"ul",
                "html":[
                    {
                        "type":"li",
                        "html":"declaraţie pe propria răspundere că nu au urmat cursurile nici unei facultăţi"
                    },
                    {
                        "type":"li",
                        "html":"adeverinţă de la facultatea urmată, care să ateste numărul de semestre finanţate de la buget de care au beneficiat"
                    }
                ]
            },
            {
                "type":"p",
                "html":"Întrucât candidaţii au dreptul de a se prezenta concomitent la două sau mai multe domenii, în vederea admiterii în învăţământul superior, dosarul cu actele originale se depune la prima opţiune. Înscrierea pentru celelalte domenii se face pe baza documentelor mai sus menţionate, prezentate în copie (pentru domeniile din Universitatea „Alexandru Ioan Cuza” Iaşi) sau în copie legalizată (pentru domeniile altor instituţii în afara Universităţii „Alexandru Ioan Cuza” Iaşi), la care se adaugă o adeverinţă de înscriere de la facultatea unde s-a depus dosarul cu actele originale. Indiferent dacă Facultatea de Informatică reprezintă sau nu prima opţiune, testul scris este obligatoriu pentru toţi candidaţii"
            }

        ]
    });
});

$(function () {
    $("#myform5").dform({
        "action": "http://localhost:8090/form",
		"method": "post",
        "html": [{
                "type": "h4",
                "html": "V. Informaţii privind documentele de studii depuse la dosar",
                "class": "sub-title"
            },

            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input-row",
                                "html": [{
                                        "name": "documente-diploma-bac-or",
                                        "caption": "Diploma de bacalaureat (original)",
                                        "type": "checkbox",
                                        "class": "checkbox"
                                    },


                                ]
                            },


                        ]
                    },
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input-row",
                                "html": [{
                                        "name": "documente-diploma-bac-copie",
                                        "caption": "Diploma de bacalaureat (copie legalizată)",
                                        "type": "checkbox",
                                        "class": "checkbox"
                                    },


                                ]
                            },


                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input-row",
                                "html": [{
                                        "name": "documente-adeverinta-or",
                                        "caption": "Adeverinţă (original)",
                                        "type": "checkbox",
                                        "class": "checkbox"
                                    },


                                ]
                            },


                        ]
                    },
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input-row",
                                "html": [{
                                        "name": "documente-adeverinta-copie",
                                        "caption": "Adeverinţă (copie legalizată)",
                                        "type": "checkbox",
                                        "class": "checkbox"
                                    },


                                ]
                            },


                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input-row",
                                "html": [{
                                        "name": "documente-echiv-studii-or",
                                        "caption": "Document echivalare studii (original)",
                                        "type": "checkbox",
                                        "class": "checkbox"
                                    },


                                ]
                            },


                        ]
                    },
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input-row",
                                "html": [{
                                        "name": "documente-echiv-studii-copie",
                                        "caption": "Document echivalare studii (copie legalizată)",
                                        "type": "checkbox",
                                        "class": "checkbox"
                                    },


                                ]
                            },


                        ]
                    },

                ]
            },

            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input-row",
                                "html": [{
                                        "name": "documente-diploma-olimp-or",
                                        "caption": "Diplomă olimpiadă (original)",
                                        "type": "checkbox",
                                        "class": "checkbox"
                                    },


                                ]
                            },


                        ]
                    },
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input-row",
                                "html": [{
                                        "name": "participare-alta-admitere",
                                        "caption": "Participaţi la alt/e concurs/uri de admitere?",
                                        "type": "checkbox",
                                        "class": "checkbox"
                                    },


                                ]
                            },


                        ]
                    },

                ]
            },
            {
                "type": "h5",
                "html": "La ce alte concursuri de admitere participaţi? ",
                "class": "sub-title"
            },

            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "h5",
                                "html": "Facultatea ",
                                "class": "sub-title"
                            },


                        ]
                    },
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "h5",
                                "html": "Domeniu/Specializarea ",
                                "class": "sub-title"
                            },


                        ]
                    },

                ]
            },

            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "alta-facultate-alfa",
                                    "type": "text",
                                    "class": "form-control"
                                }

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "alt-domeniu-alfa",
                                "type": "text",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "alta-facultate-alfa",
                                    "type": "text",
                                    "class": "form-control"
                                }

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "alt-domeniu-alfa",
                                "type": "text",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "alta-facultate-alfa",
                                    "type": "text",
                                    "class": "form-control"
                                }

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "alt-domeniu-alfa",
                                "type": "text",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "alta-facultate-alfa",
                                    "type": "text",
                                    "class": "form-control"
                                }

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "alt-domeniu-alfa",
                                "type": "text",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
        ]
    });
});

$(function () {
    $("#myform8").dform({
        "action": "http://localhost:8090/form",
		"method": "post",
        "html": [{
                "type": "h4",
                "html": "VII. Chestionar privind alegerea Dumneavoastră",
                "class": "sub-title"
            },
            {
                "type": "h5",
                "html": "1. De unde ați aflat despre admiterea la Universitatea „Alexandru Ioan Cuza” din Iași (UAIC)?  (puteți evidenția mai multe surse)",
                "class": "sub-title"
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input-row",
                                "html": [{
                                        "name": "sursa-info-site-admitere-alfn",
                                        "caption": "Site-ul dedicat admiterii (admitere.uaic.ro)",
                                        "type": "checkbox",
                                        "class": "checkbox"
                                    },


                                ]
                            },


                        ]
                    },
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input-row",
                                "html": [{
                                        "name": "sursa-info-site-fac",
                                        "caption": "Site-ul facultății",
                                        "type": "checkbox",
                                        "class": "checkbox"
                                    },


                                ]
                            },


                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input-row",
                                "html": [{
                                        "name": "sursa-info-brosura",
                                        "caption": "Broșură sau pliant despre admitere",
                                        "type": "checkbox",
                                        "class": "checkbox"
                                    },


                                ]
                            },


                        ]
                    },
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input-row",
                                "html": [{
                                        "name": "sursa-info-facebook",
                                        "caption": "Pagina de Facebook a Universității",
                                        "type": "checkbox",
                                        "class": "checkbox"
                                    },


                                ]
                            },


                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input-row",
                                "html": [{
                                        "name": "sursa-info-prieteni",
                                        "caption": "Prieteni, cunoștințe, rude",
                                        "type": "checkbox",
                                        "class": "checkbox"
                                    },


                                ]
                            },


                        ]
                    },
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input-row",
                                "html": [{
                                        "name": "sursa-info-porti-deschise",
                                        "caption": "Săptămâna Porților Deschise la UAIC",
                                        "type": "checkbox",
                                        "class": "checkbox"
                                    },


                                ]
                            },


                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input-row",
                                "html": [{
                                        "name": "sursa-info-prezentare-liceu",
                                        "caption": "Am participat la o prezentare în liceu",
                                        "type": "checkbox",
                                        "class": "checkbox"
                                    },


                                ]
                            },


                        ]
                    },
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input-row",
                                "html": [{
                                        "name": "sursa-info-profesori-liceu",
                                        "caption": "Profesorii din liceu",
                                        "type": "checkbox",
                                        "class": "checkbox"
                                    },


                                ]
                            },


                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input-row",
                                "html": [{
                                        "name": "sursa-info-presa",
                                        "caption": "Presă",
                                        "type": "checkbox",
                                        "class": "checkbox"
                                    },


                                ]
                            },


                        ]
                    },
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "div",
                                "class": "custom-input",
                                "html": [{
                                        "name": "sursa-info-altele-alfn",
                                        "caption": "Alte surse (menționați care) :",
                                        "type": "text",
                                        "class": "form-control"
                                    },


                                ]
                            },


                        ]
                    },

                ]
            },
            {
                "type": "h5",
                "html": "2. Cât de importanți au fost următorii factorii în alegerea facultății, apreciaţi cât de mult a contat fiecare în opţiunea dv. privind alegerea facultăţii? (0 – deloc, ... 5 – foarte mult)",
                "class": "sub-title"
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [
                {
                       
                        "type": "div",

                        "class": "custom-input",
                        "html": [{
                                "name": "option-test",
                                "type": "select",
                                "class": "form-control",
                                "caption": "Prestigiul Universității/facultății",
                                "options": {
                                    "0": "0",
                                    "1": "1",
                                    "2": "2",
                                    "3": "3",
                                    "4": "4",
                                    "5": "5",

                                },
                            }

                        ]
                    
                    },
                   {
                       
                        "type": "div",

                        "class": "custom-input",
                        "html": [{
                                "name": "option-test",
                                "type": "select",
                                "class": "form-control",
                                "caption": "Calitatea educației la UAIC",
                                "options": {
                                    "0": "0",
                                    "1": "1",
                                    "2": "2",
                                    "3": "3",
                                    "4": "4",
                                    "5": "5",

                                },
                            }

                        ]
                    
                    },
                    {
                       
                        "type": "div",

                        "class": "custom-input",
                        "html": [{
                                "name": "option-test",
                                "type": "select",
                                "class": "form-control",
                                "caption": "Sfatul persoanelor apropiate",
                                "options": {
                                    "0": "0",
                                    "1": "1",
                                    "2": "2",
                                    "3": "3",
                                    "4": "4",
                                    "5": "5",

                                },
                            }

                        ]
                    
                    },
                     {
                       
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "option-test",
                                "type": "select",
                                "class": "form-control",
                                "caption": "Statutul profesiei pentru care optaţi",
                                "options": {
                                    "0": "0",
                                    "1": "1",
                                    "2": "2",
                                    "3": "3",
                                    "4": "4",
                                    "5": "5",

                                },
                            }

                        ]
                    
                    }
                ]
            },
            
            {
                "type": "div",
                "class": "form-group",
                "html": [
                {
                       
                        "type": "div",

                        "class": "custom-input",
                        "html": [{
                                "name": "option-test",
                                "type": "select",
                                "class": "form-control",
                                "caption": "Colegii",
                                "options": {
                                    "0": "0",
                                    "1": "1",
                                    "2": "2",
                                    "3": "3",
                                    "4": "4",
                                    "5": "5",

                                },
                            }

                        ]
                    
                    },
                   {
                       
                        "type": "div",

                        "class": "custom-input",
                        "html": [{
                                "name": "option-test",
                                "type": "select",
                                "class": "form-control",
                                "caption": "Materiile care se studiază",
                                "options": {
                                    "0": "0",
                                    "1": "1",
                                    "2": "2",
                                    "3": "3",
                                    "4": "4",
                                    "5": "5",

                                },
                            }

                        ]
                    
                    },
                    {
                       
                        "type": "div",

                        "class": "custom-input",
                        "html": [{
                                "name": "option-test",
                                "type": "select",
                                "class": "form-control",
                                "caption": "Informațiile furnizate de Universitate",
                                "options": {
                                    "0": "0",
                                    "1": "1",
                                    "2": "2",
                                    "3": "3",
                                    "4": "4",
                                    "5": "5",

                                },
                            }

                        ]
                    
                    },
                     {
                       
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "option-test",
                                "type": "select",
                                "class": "form-control",
                                "caption": "Apropierea de domiciliu",
                                "options": {
                                    "0": "0",
                                    "1": "1",
                                    "2": "2",
                                    "3": "3",
                                    "4": "4",
                                    "5": "5",

                                },
                            }

                        ]
                    
                    }
                ]
            }  ,
             {
                "type": "div",
                "html": [

                    {
                        "type": "div",
                        "html": [{
                            "name": "cerinte-facultate-info",
                            "type": "p",
                            "html": "Declar pe propria răspundere, cunoscând consecinţele administrative şi juridice ale declaraţiilor inexacte/ false, că datele furnizate în această fişă sunt conforme cu realitatea şi că am luat cunoştinţă prevederile metodologiei de admitere. ",
                            "class": "info"
                        }, ]
                    },
                    {
                        "type": "div",
                        "html": [{
                            "name": "cerinte-facultate-info",
                            "type": "p",
                            "html": "Datele declarate de Dumneavoastră sunt prelucrate de Universitatea „Alexandru Ioan Cuza” din Iaşi, în conformitate cu prevederile Legii 677/2001, privind protecţia persoanelor cu privire la prelucrarea datelor cu caracter personal şi libera circulaţie a acestor date, modificată şi completată.  ",
                            "class": "info"
                        }, ]
                    }

                ]
            }      
        ]
    });
});

$(function () {
    $("#myform7").dform({
        "action": "http://localhost:8090/form",
		"method": "post",
        "html": [{
                "type": "h4",
                "html": "VIII. Acte necesare",
                "class": "sub-title"
            },

            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "h5",
                                "html": "Fişa de înscriere ",
                                "class": "input-title"
                            },


                        ]
                    },
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "h5",
                                "html": " Fotografie tip buletin de identitate",
                                "class": "input-title"
                            },


                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "fisa-de-inscriere",
                                    "type": "file",
                                    "class": "form-control"
                                }

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "fotografie",
                                "type": "file",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "h5",
                                "html": "Diploma de bacalaureat sau echivalentă cu aceasta, recunoscută de M.E.N. ",
                                "class": "input-title"
                            },


                        ]
                    },
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "h5",
                                "html": "Certificat de naştere",
                                "class": "input-title"
                            },


                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "diploma-bac",
                                    "type": "file",
                                    "class": "form-control"
                                }

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "certificat-nastere",
                                "type": "file",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "h5",
                                "html": "Certificatul de căsătorie sau documentul care atestă schimbarea numelui",
                                "class": "input-title"
                            },


                        ]
                    },
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "h5",
                                "html": "Cartea de identitate, care atestă domiciliul în România",
                                "class": "input-title"
                            },


                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "certificat-casatorie",
                                    "type": "file",
                                    "class": "form-control"
                                }

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "carte-identitate",
                                "type": "file",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "h5",
                                "html": "Adeverinţă medicală tip ",
                                "class": "input-title"
                            },


                        ]
                    },
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "h5",
                                "html": "Chitanţă care dovedeşte plata taxei de înscriere sau actele necesare pentru scutirea de plata taxei",
                                "class": "input-title"
                            },


                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "adeverinta-medicala",
                                    "type": "file",
                                    "class": "form-control"
                                }

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "chitanta-taxa",
                                "type": "file",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },
            {
                "type": "h4",
                "html": "Candidaţii care au absolvit liceul inainte de 2016 vor depune la dosar, după caz:",
                "class": "sub-title"
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "h5",
                                "html": "Declaraţie pe propria răspundere că nu au urmat cursurile nici unei facultăţi ",
                                "class": "input-title"
                            },


                        ]
                    },
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                                "type": "h5",
                                "html": "Adeverinţă de la facultatea urmată, care să ateste numărul de semestre finanţate de la buget de care au beneficiat",
                                "class": "input-title"
                            },


                        ]
                    },

                ]
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [{
                        "type": "div",
                        "class": "information-pair",
                        "html": [{
                            "type": "div",
                            "class": "custom-input",
                            "html": [{
                                    "name": "declaratie-absolvent-2016",
                                    "type": "file",
                                    "class": "form-control"
                                }

                            ]
                        }, ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [{
                                "name": "adeverinta-semestre-finantate",
                                "type": "file",
                                "class": "form-control"
                            }

                        ]
                    },

                ]
            },

           
        ]
    });
});

function sendForm(formId){
	$.post(
		$(formId).attr("action"),
		$(formId).serialize()
	);
	alert($(formId).serialize());
}

$(document).ready(function () {

    var navListItems = $('ul.setup-panel li a'),
        allWells = $('.setup-content');

    allWells.hide();

    navListItems.click(function (e) {
        e.preventDefault();
        var $target = $($(this).attr('href')),
            $item = $(this).closest('li');

        if (!$item.hasClass('disabled')) {
            navListItems.closest('li').removeClass('active');
            $item.addClass('active');
            allWells.hide();
            $target.show();
        }
    });

    $('ul.setup-panel li.active a').trigger('click');

    // DEMO ONLY //
    $('#activate-step-2').on('click', function (e) {
        $('ul.setup-panel li:eq(1)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-2"]').trigger('click');
        $(this).remove();
    });

    $('#activate-step-3').on('click', function (e) {
        $('ul.setup-panel li:eq(2)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-3"]').trigger('click');
        $(this).remove();
    });
    $('#activate-step-4').on('click', function (e) {
        $('ul.setup-panel li:eq(3)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-4"]').trigger('click');
        $(this).remove();
    });
    $('#activate-step-5').on('click', function (e) {
        $('ul.setup-panel li:eq(4)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-5"]').trigger('click');
        $(this).remove();
    });
    $('#activate-step-6').on('click', function (e) {
        $('ul.setup-panel li:eq(5)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-6"]').trigger('click');
        $(this).remove();
    });
    $('#activate-step-7').on('click', function (e) {
        $('ul.setup-panel li:eq(6)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-7"]').trigger('click');
        $(this).remove();
    });
    $('#activate-step-8').on('click', function (e) {
        $('ul.setup-panel li:eq(7)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-8"]').trigger('click');
        $(this).remove();
    });
    $('#finish-button').on('click', function (e) {
        sendForm("#myform7");
    })
});