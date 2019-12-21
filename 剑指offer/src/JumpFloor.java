class JumpFloor{
	public int jumpFloor(int target) {
        if(target == 1||target == 0){
            return 1;
        }else{
            return (jumpFloor(target - 1) + jumpFloor(target - 2));
        }
    }
}