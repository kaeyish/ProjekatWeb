<template>
  <div id="zanrovi">
    ZANROVI
    <li v-for="zanr of zanrovi"
            :key="zanr.id"
            :zanr="zanr">
             {{ zanr.naziv }}
    </li>

  </div>
</template>

<script>
export default {
    name: 'SviZanrovi',
    data: function() {
            return {
                zanrovi: [],
            }
        },
        mounted: function () {
            fetch('http://localhost:9090/api/zanrovi')
            .then(response => response.json())
                .then(data => {console.log("Success:", data); this.zanrovi = data})
                .catch((error) => {
                    console.error("Error:", error);
                }); 
            },
            methods: 
        {
            loadZanr(zanr) {
            this.$router.push('/zanr/'+zanr.id);
        }
      }  
}
</script>

<style>

</style>