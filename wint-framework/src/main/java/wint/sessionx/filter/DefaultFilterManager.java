package wint.sessionx.filter;

import wint.lang.magic.MagicMap;
import wint.lang.utils.CollectionUtil;

import java.util.List;
import java.util.Map;

/**
 * User: longyi
 * Date: 14-2-26
 * Time: 下午1:24
 */
public class DefaultFilterManager implements FilterManager {

    private List<Filter> filters = CollectionUtil.newArrayList();

    private MagicMap initParamters;

    public DefaultFilterManager(MagicMap initParamters) {
        this.initParamters = initParamters;
    }

    public void addFilter(Filter filter) {
        filter.init(initParamters);
        filters.add(filter);
    }

    public FilterContext performFilters(Map<String, Object> initAttributes) {
        DefaultFilterContext filterContext = new DefaultFilterContext(filters.iterator());
        if (initAttributes != null) {
            for (Map.Entry<String, Object> entry : initAttributes.entrySet()) {
                filterContext.setAttribute(entry.getKey(), entry.getValue());
            }
        }
        filterContext.invokeNext();
        return filterContext;
    }

}
