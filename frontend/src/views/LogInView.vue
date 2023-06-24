
<template>
    <p/>
        LOGIN PAGE HI

        <form name="login-form" >
      <div class="mb-3">
        <label for="email">Email: </label>
        <input id="email" type="email" v-model="email" />
      </div>
      <div class="mb-3">
        <label for="lozinka">Lozinka: </label>
        <input id="lozinka" type="password" v-model="lozinka" />
      </div>
      <button class="btn btn-outline-dark" type="submit" v-on:click.prevent = "submit()" >
        Login
      </button>

</form>
</template>

<script>
// import VueSession from 'vue-session'
// Vue.use(VueSession)
export default{
    name:'LogInView',
    data() {
    return {
      email: '',
      lozinka: '',
    };
  },
  methods: {
    submit() {
      const payload = {
        email: this.email,
        lozinka: this.lozinka
      };

      fetch('http://localhost:9090/api/login', {
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
           alert("Ne mozete se ulogovati.");
          }
        })
        .then((data) => {
          console.log(data);
          localStorage.setItem('user', JSON.stringify(data));
          localStorage.setItem('uloga', JSON.stringify(data.uloga));
          localStorage.setItem('id', JSON.stringify(data.id));
          sessionStorage.setItem('id', JSON.stringify(data));
          this.$router.push('/korisnik/'+data.id);})
        .catch((err) => {
          console.log(err);
          alert('Vec ulogovan!');
        });
    }
  }
};

</script>

<style>
</style>