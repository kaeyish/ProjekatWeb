<template>
    <form name="zanr-form" >
        <div class="mb-3">
        <label for="naslov">Naslov: </label>
        <input id="naslov" type="text" v-model="naslov" />
      </div><div class="mb-3">
        <label for="slika">Link do slike bcz im tired: </label>
        <input id="slika" type="text" v-model="slika" />
      </div><div class="mb-3">
        <label for="isbn">ISBN: </label>
        <input id="isbn" type="text" v-model="isbn" />
      </div><div class="mb-3">
        <label for="brStrana">Broj strana: </label>
        <input id="brStrana" type="text" v-model="brojStrana" />
      </div>
      <div class="mb-3">
        <label for="ocena">Ocena: </label>
        <input id="ocena" type="text" v-model="ocena" />
      </div>
      <div class="mb-3">
        <label for="datum">Datum: </label>
        <input id="datum" type="date" v-model="datum" />
      </div>
      <div class="mb-3">
        <label for="opis">Opis: </label>
        <input id="opis" type="text" v-model="opis" />
      </div>
        <!-- <div id="zanrovi">
        <label for="zanr">Zanr: </label>
          <select id="zanr" v-model="zanr">
          <option v-for="zanr in zanrovi"
            :key="zanr.id"
            :zanr="zanr">
                {{ zanr.naziv }}
        </option>
        </select>
    </div> -->
      
      <button class="btn btn-outline-dark" type="submit" v-on:click.prevent = "submit()" >
        dodaj knjigu
      </button>
      </form>
</template>

<script>
export default{
    name: 'DodavanjeKnjige',
    data() {
        return {
            naslov:'',
            slika:'',
            isbn:'',
            datum:'',
            brojStrana:'',
            opis:'',
            ocena:'',
            // zanr:'',
            // zanrovi:[]
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
    methods:{

        submit(){
        const payload = {

            naslov:this.naslov,
            slika:this.slika,
            isbn:this.isbn,
            datum:this.datum,
            brojStrana:this.brojStrana,
            opis:this.opis,
            ocena:this.ocena,
             //zanr:this.zanr,
         };
        fetch('http://localhost:9090/api/korisnik/dodaj-knjigu', {
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