package fit.iuh.thanhoangthienthien_tuan07.entities;

import java.math.BigDecimal;

public class CartItemBean {

  private Product product;
  private int quantity;

  public CartItemBean() {
  }

  public CartItemBean(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * Tính thành tiền của item này (giá * số lượng)
   *
   * @return Thành tiền
   */
  public BigDecimal getSubtotal() {
    if (product != null && product.getPrice() != null) {
      return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
    return BigDecimal.ZERO;
  }

  @Override
  public String toString() {
    return "CartItemBean{" +
        "product=" + product.getName() +
        ", quantity=" + quantity +
        ", subtotal=" + getSubtotal() +
        '}';
  }
}
