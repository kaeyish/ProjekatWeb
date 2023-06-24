<template>

<p/>
        <form name="zahtev-form" >
      <div class="mb-3">
        <label for="email">Email kojim zelite da aktivirate nalog: </label>
        <input id="email" type="email" v-model="email" />
      </div>
      <div class="mb-3">
        <label for="telefon">Broj telefona: </label>
        <input id="telefon" type="text" v-model="telefon" />
      </div>
      <button class="btn btn-outline-dark" type="submit" v-on:click.prevent = "generisi()" >
        vezi korisnika :) 
      </button>
<p/>
      <button class="btn btn-outline-dark" type="submit" v-on:click.prevent = "submit()" >
        Posalji zahtev
      </button>

</form>

</template>


<script>
export default{
    name: 'NoviZahtev',
    data(){
        return {
            email:'',
            autor: '',
            status:'NA_CEKANJU',
            datum:'2021-11-11',
            poruka:'auto generated message',
            telefon:''
        }
    },
    methods:{
        generisi () {
        fetch('http://localhost:9090/api/korisnik/'+ this.$route.params.id)
        .then(response => response.json())
            .then(data => {console.log("Success:", data); this.autor = data})
    },
    submit(){
      const payload = {
        email: this.email,
        autor: this.autor,
            status:this.status,
            datum:this.datum,
            poruka:this.poruka,
            telefon:this.telefon
      };

      fetch('http://localhost:9090/api/novi-zahtev', {
        method: 'POST',
        credentials: 'include',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
      })
      .then (this.$router.push('/index'));
      
    }
    }
}
</script>