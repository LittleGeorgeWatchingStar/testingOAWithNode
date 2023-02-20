#818RaceCar
# Naive BFS
# O(2^target)
# TLE
class Solution:
    def racecar(self, target: int) -> int:
        q = deque([(0, 0, 1)])
        visited = set([0, 0, 1])
        
        while q:
            actions, x, v = q.popleft()
            if x == target:
                return actions
            
            actions += 1
            
            # Accelerate
            newx = x + v
            newv = v * 2
            if (state := (actions, newx, newv)) not in visited:
                visited.add(state)
                q.append(state)
                
            
            # Reverse
            newv = -1 if v > 0 else 1
            if (state := (actions, x, newv)) not in visited:
                visited.add(state)
                q.append(state)

                
# Smart BFS
# O(t*log(t))
class Solution:
    def racecar(self, target: int) -> int:
        q = deque([(0, 1)])
        visited = set([0, 1])
        actions = 0
        while q:
            size = len(q)
            for _ in range(size):
                x, v = q.popleft()
                if x == target:
                    return actions
                
                # Accelerate
                # NOTE: if accelerating in the negative regions or passing the target by more than two times, 
                # then this is never going to reach an answer
                # we won't add it to the queue
                newx = x + v
                newv = v * 2
                if 0 <= newx <= 2 * target and (state := (newx, newv)) not in visited:
                    visited.add(state)
                    q.append(state)


                # Reverse
                newv = -1 if v > 0 else 1
                if (state := (x, newv)) not in visited:
                    visited.add(state)
                    q.append(state)
                    
            actions += 1
                    
# DP
# O(t*log(t))
class Solution:
    def racecar(self, target: int) -> int:
        
        @cache
        def go(n):
            m = n.bit_length()
            # check if we can go directly to the target
            if 2 ** m - 1 == n:
                return m
            else:
                # otherwise we have two choices
                # we pass the point, and then we reverse (denoted by passing_moves)
                # or we go as close to the target as possible, reverse, go back up to m - 2 times, reverse again, and reach the point
                # note if we go back m - 1 times, we have reached the same point we started at.
                
                # 1. go past target (m moves), reverse (1 move), and reach the target (recurse)
                passing_moves = m + 1 + go(2 ** m - 1 - n)
                
                # 2. go as close to target as possible (m - 1 moves), reverse (1 move) and go back (i < m - 1 moves), reverse (1 move), and reach the target (recurse)
                closest_point = 2 ** (m - 1) - 1
                closest_moves = m - 1
                min_ = math.inf
                for i in range(m - 1):
                    backward = 2 ** i - 1
                    remain_moves = go(n - (closest_point - backward)) + i
                    min_ = min(min_, remain_moves)
                    
                closest_moves += min_ + 2
                
                return min(passing_moves, closest_moves)
            
        return go(target)