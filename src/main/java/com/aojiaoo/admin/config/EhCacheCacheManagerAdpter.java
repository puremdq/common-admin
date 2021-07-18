///*
// * Copyright 2002-2020 the original author or authors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      https://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.aojiaoo.admin.config;
//
//import java.util.Collection;
//import java.util.LinkedHashSet;
//
//
//import org.ehcache.Status;
//import org.ehcache.core.EhcacheManager;
//import org.springframework.cache.Cache;
//import org.springframework.cache.transaction.AbstractTransactionSupportingCacheManager;
//import org.springframework.lang.Nullable;
//import org.springframework.util.Assert;
//
///**
// * CacheManager backed by an EhCache {@link net.sf.ehcache.CacheManager}.
// *
// * @author Costin Leau
// * @author Juergen Hoeller
// * @author Stephane Nicoll
// * @since 3.1
// * @see EhCacheCache
// */
//public class EhCacheCacheManagerAdpter extends AbstractTransactionSupportingCacheManager {
//
//	@Nullable
//	private EhcacheManager cacheManager;
//
//
//
//	/**
//	 * Create a new EhCacheCacheManager for the given backing EhCache CacheManager.
//	 * @param cacheManager the backing EhCache {@link net.sf.ehcache.CacheManager}
//	 */
//	public EhCacheCacheManagerAdpter(EhcacheManager cacheManager) {
//		this.cacheManager = cacheManager;
//	}
//
//
//	/**
//	 * Set the backing EhCache {@link net.sf.ehcache.CacheManager}.
//	 */
//	public void setCacheManager(@Nullable EhcacheManager cacheManager) {
//		this.cacheManager = cacheManager;
//	}
//
//	/**
//	 * Return the backing EhCache {@link net.sf.ehcache.CacheManager}.
//	 */
//	@Nullable
//	public EhcacheManager getCacheManager() {
//		return this.cacheManager;
//	}
//
//
//
//
//	@Override
//	protected Collection<Cache> loadCaches() {
//		EhcacheManager cacheManager = getCacheManager();
//		Assert.state(cacheManager != null, "No CacheManager set");
//
//		Status status = cacheManager.getStatus();
//		if (!Status.AVAILABLE.equals(status)) {
//			throw new IllegalStateException(
//					"An 'alive' EhCache CacheManager is required - current cache is " + status.toString());
//		}
//
//		String[] names = getCacheManager().ge();
//		Collection<Cache> caches = new LinkedHashSet<>(names.length);
//		for (String name : names) {
//			caches.add(new EhCacheCache(getCacheManager().getEhcache(name)));
//		}
//		return caches;
//	}
//
//	@Override
//	protected Cache getMissingCache(String name) {
//		net.sf.ehcache.CacheManager cacheManager = getCacheManager();
//		Assert.state(cacheManager != null, "No CacheManager set");
//
//		// Check the EhCache cache again (in case the cache was added at runtime)
//		Ehcache ehcache = cacheManager.getEhcache(name);
//		if (ehcache != null) {
//			return new EhCacheCache(ehcache);
//		}
//		return null;
//	}
//
//}
