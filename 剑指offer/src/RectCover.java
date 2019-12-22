public class RectCover {
    public int rectCover(int target) {
        if(target <= 2){
            return target;
        }else{
            return rectCover(target - 1) + rectCover(target - 2);
        }
    }
}