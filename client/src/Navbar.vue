<template>
    <b-navbar>
        <b-nav pills>
            <b-nav-item v-for="item in items" :href="`#/${item.link}`" :key="item.link">
                {{item.title}}
            </b-nav-item>
        </b-nav>
    </b-navbar>
</template>

<script>

    export default {
        name: 'navbar',
        data() {
            return {
                items: [
                    {
                        link: 'ads',
                        title: 'Ads'
                    }
                ]
            }
        }
    }
</script>