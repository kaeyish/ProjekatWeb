<template>
    <form name="polica-form" >
      <div class="mb-3">
        <label for="naziv">Naziv: </label>
        <input id="naziv" type="text" v-model="naziv" />
      </div>
      <button class="btn btn-outline-dark" type="submit" v-on:click.prevent = "generisi()" >
        vezi korisnika :) 
      </button>
      <p/>
      <button class="btn btn-outline-dark" type="submit" v-on:click.prevent = "submit()" >
        dodaj policu
      </button>
      </form>
</template>


<script>
export default{
    name: 'AddPolicuVIew',
    data() {
        return {
            naziv:'',
            korisnik:{}
    }
    },
    methods:{
        generisi () {
        fetch('http://localhost:9090/api/korisnik/'+ this.$route.params.id)
        .then(response => response.json())
            .then(data => {console.log("Success:", data); this.korisnik = data})
    },
        submit(){
        const payload = {
        naziv: this.naziv,
        korisnik: this.korisnik };
        fetch('http://localhost:9090/api/nova-polica', {
        method: 'POST',
        credentials: 'include',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
      })
      .then (this.$router.push("/korisnik/"+this.korisnik.id));
        }
    }



}
</script>