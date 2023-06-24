
<template>
    <p/>
        UNESITE SVOJE PODATKE:
        <form name="register-form" >
        <div class="mb-3">
            <label for="ime">Ime: </label>
            <input id="ime" type="text" v-model="ime" />
        </div>
        <div class="mb-3">
            <label for="prezime">Prezime: </label>
            <input id="prezime" type="text" v-model="prezime" />
        </div>
      
        <div class="mb-3">
            <label for="korisnickoIme">Korisnicko Ime: </label>
            <input id="korisnickoIme" type="text" v-model="korisnickoIme" />
        </div>
        <div class="mb-3">
        <label for="email">Email: </label>
        <input id="email" type="email" v-model="email" />
      </div>
      <div class="mb-3">
        <label for="lozinka">Lozinka: </label>
        <input id="lozinka" type="password" v-model="lozinka" />
      </div>
      <div class="mb-3">
        <label for="potvrdaLozinke">Potvrda lozinke: </label>
        <input id="potvrdaLozinke" type="password" v-model="potvrdaLozinke" />
      </div>
      <button class="btn btn-outline-dark" type="submit" v-on:click.prevent = "submit()" >
        REGISTER
      </button>

</form>
</template>

<script>
export default{
    name:'RegisterView',
    data() {
    return {
    ime:'',
    prezime:'',
      email: '',
      lozinka: '',
      potvrdaLozinke:'',
      korisnickoIme:''
    };
  },
  methods: {
    submit() {
      const payload = {
        email: this.email,
        lozinka: this.lozinka,
        ime: this.ime,
        prezime: this.prezime,
        potvrdaLozinke: this.potvrdaLozinke,
        korisnickoIme: this.korisnickoIme
      };

      fetch('http://localhost:9090/api/registracija', {
        method: 'POST',
        credentials: 'include',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
      })
        .then((res) => {
          console.log(res);
          if (res.ok) {
            return res.json();
          } else {
            throw new Error('Registration failed');
          }
        })
        .then((data) => {
          console.log(data);
            this.$router.push('/userProfile');
        })
        .catch((err) => {
          console.log(err);
          alert('Something went wrong!');
        });
    }
  }
};

</script>

<style>
</style>