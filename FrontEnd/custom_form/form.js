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
                                  "maxlength":"10"
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
                         "type": "select",
                         "class": "form-control",
                         "caption": "Sex",
                         "options": {
                             "fe": "Feminin",
                             "ma": "Masculin",
                             "ot":"Other"
                         }
                     }

                    ]
                },

          ]
      },
        ]
    });
});
// Activate Next Step

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


