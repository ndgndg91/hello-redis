# Redis-Performance

```
% brew install jmeter

% open /usr/local/bin/jmeter
```

```
% /usr/local/bin/jmeter -n -t Redis-Performance.jmx -l ./v1.jtl

WARNING: package sun.awt.X11 not in java.desktop
Creating summariser <summary>
Created the tree successfully using Redis-Performance.jmx
Starting standalone test @ 2022 Oct 9 16:16:16 KST (1665299776726)
Waiting for possible Shutdown/StopTestNow/HeapDump/ThreadDump message on port 4445
summary +  18350 in 00:00:13 = 1388.3/s Avg:    31 Min:     2 Max:   134 Err:     0 (0.00%) Active: 87 Started: 87 Finished: 0
summary +  56931 in 00:00:30 = 1897.7/s Avg:    88 Min:    35 Max:  1223 Err:     0 (0.00%) Active: 200 Started: 200 Finished: 0
summary =  75281 in 00:00:43 = 1741.9/s Avg:    74 Min:     2 Max:  1223 Err:     0 (0.00%)
summary +  32990 in 00:00:17 = 1948.3/s Avg:   102 Min:    84 Max:   249 Err:     0 (0.00%) Active: 0 Started: 200 Finished: 200
summary = 108271 in 00:01:00 = 1800.0/s Avg:    82 Min:     2 Max:  1223 Err:     0 (0.00%)
Tidying up ...    @ 2022 Oct 9 16:17:16 KST (1665299836933)
... end of run
```

## V1 - not applied redis
<img width="1843" alt="스크린샷 2022-10-09 오후 4 26 35" src="https://user-images.githubusercontent.com/19872667/194743681-ff150a0a-aec8-43cb-9119-1643b732fd79.png">


## V2 - applied redis