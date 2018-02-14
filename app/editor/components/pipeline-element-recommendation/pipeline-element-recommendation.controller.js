export class PipelineElementRecommendationController {

    constructor() {

    }

    getUnskewStyle() {
        var unskew = -(this.getSkew());
        var rotate = -(90 - (this.getSkew() / 2));

        return {
            "transform": "skew(" + unskew + "deg)" + " rotate(" + rotate + "deg)" + " scale(1)"
        };
    }

    getSkewStyle(index) {
        this.fillRemainingItems();
        // transform: rotate(72deg) skew(18deg);
        var skew = this.getSkew();
        var rotate = (index + 1) * this.getAngle();

        return {
            "transform": "rotate(" + rotate + "deg) skew(" + skew + "deg)"
        };
    }

    getUnskewStyleLabel(index) {
        var unskew = -(this.getSkew());
        var rotate =  (index + 1) * this.getAngle();
        var unrotate = -360 + (rotate*-1);

        return {
            "transform": "skew(" + unskew + "deg)" + " rotate(" + unrotate + "deg)" + " scale(1)"
        };
    }

    getSkew() {
        return (90 - this.getAngle());
    }

    getAngle() {
        return (360 / this.recommendedElements.length);
    }

    fillRemainingItems() {
        if (this.recommendedElements.length < 6) {
            for (var i = this.recommendedElements.length; i < 6; i++) {
                this.recommendedElements.push({fakeElement: true});
            }
        }
    }

}

PipelineElementRecommendationController.$inject = [];