package mas.delivery;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @NotBlank
    private String comment;

    @Min(0)
    @Max(5)
    private int stars;

    @OneToOne(mappedBy = "review")
    private DeliveryOrder deliveryOrder;

    public Review(@NotBlank String comment, @Min(0) @Max(5) int stars) {
        this.comment = comment;
        this.stars = stars;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public DeliveryOrder getDeliveryOrder() {
        return deliveryOrder;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
