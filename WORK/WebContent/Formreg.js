// define language anchors
        var datareload = document.querySelectorAll("[data-reload]");

        // Language translations
        var language = {
            eng: {
                welcome: "Welcome everyone!"
            },
            es: {
                welcome: "Bienvenidos todos!"
            },
            it: {
                welcome: "Benvenuti a tutti!"
            },
            fr: {
                welcome: "Bienvenue à tous!"
            }
        };
        // Define language via window hash
        if (window.location.hash) {
            if (window.location.hash === "#eng") {
                hi.textContent = language.eng.welcome;
            }
            if (window.location.hash === "#es") {
                hi.textContent = language.es.welcome;
            }
            if (window.location.hash === "#it") {
                hi.textContent = language.it.welcome;
            }
            if (window.location.hash === "#fr") {
                hi.textContent = language.fr.welcome;
            }
        }

        // define language reload onclick iteration
        for (i = 0; i <= datareload.length; i++) {
            datareload[i].onclick = function() {
                location.reload(true);
            };
        }
    

        $('.message a').click(function() {
            $('.form').animate({
                height: "toggle",
                opacity: "none"
            }, "slow");
        });
        
        $('select[name="ap"]').append($('<option>', {value:'http://www.google.com', text:'Google'}));    
        $('select[name="ap"]').append($('<option>', {value:'http://www.google.co.uk', text:'Google UK'}));    
        $('select[name="ap"]').append($('<option>', {value:'http://www.google.fr', text:'Google FR'}));    