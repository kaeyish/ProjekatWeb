
<template>
<form>//POPOUNITI</form>
</template>

<script>
export default{
    name: 'DodavanjeAutora',
    data() {
        return {
            //POPOUNITI
    }
    },
    methods:{

        submit(){
        const payload = {
            aktivnost:true,
            //POPOUNITI
         };
        fetch('http://localhost:9090/api/korisnik/kreiranjeAutora', {
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