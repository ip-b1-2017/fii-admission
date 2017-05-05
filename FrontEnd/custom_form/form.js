$(function () {
    $("#myform").dform({
        "action": "form.html",
        "method": "get",
        "html":
        [
            {
                "type": "div",
                "class": "form-group",
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "initial-name",
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
                        "html": [
                            {
                                "name": "parent-initial",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "actual-name",
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
                        "html": [
                            {
                                "name": "prenume",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "mother-name",
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
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "father-name",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "initial-name",
                                        "caption": "CNP",
                                        "type": "text",
                                        "placeholder": "2780923232",
                                        "class": "form-control",
                                        "maxlength": "10"
                                    }

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",

                        "class": "custom-input",
                        "html": [
                            {
                                "name": "sex",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "birth-date",
                                        "caption": "Data Nasterii",
                                        "type": "text",
                                        "class": "form-control"
                                    }

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "tara-nasterii",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "judetul-nasterii",
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
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "orasul-nasterii",
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
            }
        ]
    });
});


$(function () {
    $("#myform2").dform({
        "action": "form2.html",
        "method": "get",
        "html":
        [
            {
                "type": "h4",
                "html": " II.a. Studiile preuniversitare absolvite, nivel liceu",
                "class": "sub-title"
            },
            {
                "type": "div",
                "class": "form-group",
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "graduate-institution",
                                        "caption": "Instituţia unde a absolvit ",
                                        "type": "text",
                                        "placeholder": "Ex. Liceul Teoretic de Informatică \"Grigore Moisil\"",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "country",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "town",
                                        "caption": "Localitatea",
                                        "type": "text",
                                        "placeholder": "Ex. Iași",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "city",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "field",
                                        "caption": "Profilul/Domeniul",
                                        "type": "text",
                                        "placeholder": "Ex. Matematică-Informatică",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "length-of-studies",
                                "caption": "Durata studiilor",
                                "type": "text",
                                "placeholder": "Ex. 4 ani",
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
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "graduation-year",
                                        "caption": "Anul absolvirii",
                                        "type": "number",
                                        "min": "1950",
                                        "max": "2015",
                                        "placeholder": "Ex. 2010",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "education-form",
                                "caption": "Forma de invățământ",
                                "type": "radiobuttons",
                                "class": "radio-inline",
                                "options": {
                                    "zi": "Zi",
                                    "seral": "Seral",
                                    "fr": "FR",
                                    "ip": "IP"

                                },


                            }

                        ]
                    },

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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "bac-series",
                                        "caption": "Seria",
                                        "type": "text",
                                        "placeholder": "Ex. n2s90",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "bac-number",
                                "caption": "Numarul",
                                "type": "text",
                                "placeholder": "Ex. 3123",
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
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "issued-by",
                                        "caption": "Emisă de",
                                        "type": "text",
                                        "placeholder": "Ex. n2s90",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "bac-number",
                                "caption": "Data emiterii",
                                "type": "text",
                                "placeholder": "Ex. 21/04/20016",
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
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "nr-foaie-matricola",
                                        "caption": "Numărul foii matricole care însoțește actul de studii",
                                        "type": "text",
                                        "placeholder": "Ex. ncc32s90",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "nr_echivalare",
                                        "caption": "Număr",
                                        "type": "text",
                                        "placeholder": "Ex. 12353",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "serie-echivalare",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "nr-foaie-matricola",
                                        "caption": "Data echivalării",
                                        "type": "text",
                                        "placeholder": "Ex. 21/04/20016",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "st-la-alta-fac-checkbox",
                                        "caption": "Student la altă facultate/ universitate",
                                        "type": "checkbox",
                                        "class": "checkbox"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "tara-alte-studii",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "alte-studii-localitate",
                                        "caption": "Localitatea",
                                        "type": "text",
                                        "placeholder": "Ex. Paris",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "alte-studii-judetul",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "alte-studii-institutie",
                                        "caption": "Denumirea instituţiei de învăţământ superior  ",
                                        "type": "text",
                                        "placeholder": "Ex. ",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "alte-studii-facultatea",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "alte-studii-domeniu-licenta",
                                        "caption": "Domeniul de licenţă  ",
                                        "type": "text",
                                        "placeholder": "Ex. ",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "alte-studii-specializarea",
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
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "education-form",
                                        "caption": "Forma de invățământ",
                                        "type": "radiobuttons",
                                        "class": "radio-inline",
                                        "options": {
                                            "zi": "Zi",
                                            "seral": "Seral",
                                            "fr": "FR",
                                            "ip": "IP"

                                        },


                                    }
                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "alte-studii-anul",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "alte-studii-semestre-la-buget",
                                        "caption": "Numărul semestrelor finanţate de la bugetul de stat",
                                        "type": "number",
                                        "placeholder": "Ex. ",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "alte-studii-semestre-la-bursa",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "absolvent-licenta-an",
                                        "caption": "Anul",
                                        "type": "number",
                                        "placeholder": "Ex. ",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                        "name": "absolvent-licenta-diploma",
                                        "type": "radiobuttons",
                                        "class": "radio-inline",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "abslovent-licenta-tara",
                                        "caption": "Țara",
                                        "type": "text",
                                        "placeholder": "Ex. ",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "absolvett-licenta-localitatea",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "abslovent-licenta-judet",
                                        "caption": "Județul",
                                        "type": "text",
                                        "placeholder": "Ex. ",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "absolvett-licenta-institutie",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "abslovent-licenta-facultate",
                                        "caption": "Facultatea",
                                        "type": "text",
                                        "placeholder": "Ex. ",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "absolvett-licenta-domeniu-licenta",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "abslovent-licenta-specializare",
                                        "caption": "Programul de studii /Specializarea ",
                                        "type": "text",
                                        "placeholder": "Ex. ",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "absolvett-licenta-titlu",
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
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "abslovent-licenta-forma-invat",
                                        "caption": "Forma de invățământ",
                                        "type": "radiobuttons",
                                        "class": "radio-inline",
                                        "options": {
                                            "zi": "Zi",
                                            "seral": "Seral",
                                            "fr": "FR",
                                            "ip": "IP"

                                        },


                                    }
                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "absolvent-licenta-semestre-buget",
                                "caption": "Numărul semestrelor finanţate de la bugetul de stat",
                                "type": "number",
                                "placeholder": "Ex. 2",
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
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "abslovent-licenta-semestre-bursa",
                                        "caption": "Numărul semestrelor în care aţi beneficiat de bursă",
                                        "type": "number",
                                        "placeholder": "Ex. ",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "absolvett-licenta-durata-studii",
                                "caption": "Durata studiilor (număr de ani)  ",
                                "type": "text",
                                "placeholder": "Ex. ",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "abslovent-licenta-diploma-seria",
                                        "caption": "Seria",
                                        "type": "text",
                                        "placeholder": "Ex. ",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "absolvett-licenta-diploma-numar",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "abslovent-licenta-diploma-emisade",
                                        "caption": "Emisă de ",
                                        "type": "text",
                                        "placeholder": "Ex. ",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "absolvett-licenta-diploma-data",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "absolvent-licenta-diploma-nr-supliment",
                                        "caption": "Numărul suplimentului / foii matricole care însoțește actul de studii",
                                        "type": "text",
                                        "placeholder": "Ex. ncc32s90",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "nr_echivalare",
                                        "caption": "Număr",
                                        "type": "text",
                                        "placeholder": "Ex. 12353",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },

                    {
                        "type": "div",
                        "class": "custom-input",
                        "html": [
                            {
                                "name": "serie-echivalare",
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
                "html": [
                    {
                        "type": "div",
                        "class": "information-pair",
                        "html": [
                            {
                                "type": "div",
                                "class": "custom-input",
                                "html": [
                                    {
                                        "name": "nr-foaie-matricola",
                                        "caption": "Data echivalării",
                                        "type": "text",
                                        "placeholder": "Ex. 21/04/20016",
                                        "class": "form-control"
                                    },

                                ]
                            },
                        ]
                    },


                ]
            },


        ]
    });
});


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
    })

    $('#activate-step-3').on('click', function (e) {
        $('ul.setup-panel li:eq(2)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-3"]').trigger('click');
        $(this).remove();
    })

    $('#activate-step-4').on('click', function (e) {
        $('ul.setup-panel li:eq(3)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-4"]').trigger('click');
        $(this).remove();
    })

    $('#activate-step-3').on('click', function (e) {
        $('ul.setup-panel li:eq(2)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-3"]').trigger('click');
        $(this).remove();
    })
});



