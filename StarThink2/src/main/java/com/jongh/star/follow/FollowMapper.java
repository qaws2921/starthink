package com.jongh.star.follow;

import java.util.List;

public interface FollowMapper {
	
	public abstract List<Follow> following(Follow fo);
	public abstract List<Follow> follower(Follow fo);
	public abstract List<Follow> followerCheck(Follow fo);
	public abstract int followerDelete(Follow fo);
	public abstract int followerReg(Follow fo);
}
