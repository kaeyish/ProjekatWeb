<template>
  <label>Naziv: </label>
  <input v-model="zanr.naziv">
  <br>
  <button v-on:click="submit()">submit</button>
</template>

<script>
export default {
    name: "DodajZanr",
    data : function(){
        return {
            zanr: {
                naziv: "",
            },
        };
    },
    methods: {
        submit: function(){
            fetch("http://localhost:9090/api/korisnik/dodajZanr", {
                method: "POST",
                headers: {
                Accept: "application/json",
                "Content-type": "application/json",
                },
                body: JSON.stringify(this.zanr),
            })
                .then((response) => response.json)
                .then((data) => {
                console.log("Success : " + data);
                this.$router.push("/zanrovi");
                })
                .catch((err) => {
                console.log("Error : " + err);
                alert(err);
                });
                }
    }
}
</script>

<style>

</style>