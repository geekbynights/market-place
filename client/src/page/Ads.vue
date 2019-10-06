<template>
    <b-container>
        <hr>
        <b-row>
            <b-card-group deck v-for="i in cardGroupSize" :key="i">
                <b-card v-for="ad in getAdsFor(i)"
                        :key="ad.id"
                        border-variant="secondary"
                        :title="ad.title"
                        class="mb-4"
                        style="min-height: 15rem; width: 15rem">
                    <b-card-body>
                        <b-button variant="primary" :href="generateAdLink(ad.id)">Details</b-button>
                    </b-card-body>
                </b-card>
            </b-card-group>
        </b-row>
    </b-container>
</template>

<script>

    export default {
        name: 'ads',
        created() {
            this.loadAds()
        },
        data() {
            return {
                ads: []
            }
        },
        computed: {
            cardGroupSize() {
                const length = this.ads.length;
                return Math.ceil(length / 4)
            }
        },
        methods: {
            loadAds() {
                this.$http.get("ad-list")
                    .then(response => {
                        this.ads = response.body
                    })
            },
            getAdsFor(i) {
                return this.ads.slice((i - 1) * 4, Math.min(i * 4, this.ads.length));
            },
            generateAdLink(adId) {
                return `#/ad/${adId}`
            }
        }
    }
</script>