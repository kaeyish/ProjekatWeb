<template>
    <p/>
</template>


<script>
export default{
    name: "LogOutView",
    mounted: function () {
            fetch('http://localhost:9090/api/logout',{
        method: 'POST',
        credentials: 'include',
        headers: {
          'Content-Type': 'application/json'
        },})
            .then(response => response.json())
                .then(data => {console.log("Success:", JSON.stringify(data));})
                .then (this.$router.push('/index'))
                .catch((error) => {
                    console.error("Error:", error);
                });    
        }
}
</script>