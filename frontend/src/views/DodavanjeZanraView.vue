<template>
    <form name="zanr-form" >
      <div class="mb-3">
        <label for="naziv">Naziv: </label>
        <input id="naziv" type="text" v-model="naziv" />
      </div>
      <button class="btn btn-outline-dark" type="submit" v-on:click.prevent = "submit()" >
        dodaj zanr
      </button>
      </form>
</template>

<script>
export default{
    name: 'DodavanjeZanra',
    data() {
        return {
            naziv:'',
    }
    },
    methods:{

        submit(){
        const payload = {
        naziv: this.naziv };
        fetch('http://localhost:9090/api/korisnik/dodajZanr', {
        method: 'POST',
        credentials: 'include',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
      })
      .then (this.$router.push("/index"));
        }
    }

}
</script>