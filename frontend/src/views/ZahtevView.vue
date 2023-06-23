<template>

    <div class="card">
        {{ zahtev.poruka }}
    </div>
        
</template>
    
    <script>
    export default{
        name: 'ZahtevView',   
        data: function() {
            return {
                zahtev: {},
            }
        },
        mounted: function () {
            fetch('http://localhost:9090/api/zahtevi/'+ this.$route.params.id + "/" + this.$route.params.korisnik_id)
            .then(response => response.json())
                .then(data => {console.log("Success:", data); this.zahtev = data})
                .catch((error) => {
                    console.error("Error:", error);
                });    
        }
    
    }
    </script>
    <style>
    </style>